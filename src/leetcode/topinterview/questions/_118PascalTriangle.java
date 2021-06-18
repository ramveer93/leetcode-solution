package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

public class _118PascalTriangle {
	public static void main(String[] args) {
		System.out.println(new _118PascalTriangle().generate(4).toString());

	}

	public List<List<Integer>> generate(int n) {
		List<List<Integer>> res = new ArrayList<>();
		if (n == 0)
			return res;

		res.add(new ArrayList<>());
		res.get(0).add(1);

		// 0th and last element of every list will always be 1

		for (int i = 1; i < n; i++) { // we have already add one element so left with n-1 elements hence i starts with 1
			List<Integer> list = new ArrayList<>();
			List<Integer> prev = res.get(i - 1);
			list.add(1); // first element always 1;
			for (int j = 1; j < i; j++) {
				list.add(prev.get(j - 1) + prev.get(j));

			}
			list.add(1); // last element always 1
			res.add(list);
		}
		List<Integer> tt = res.get(n-1);
		System.out.println(tt.toString());

		return res;

	}

}
