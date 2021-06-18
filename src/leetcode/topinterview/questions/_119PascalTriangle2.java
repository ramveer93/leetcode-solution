package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

public class _119PascalTriangle2 {
	public static void main(String[] args) {
		System.out.println(new _119PascalTriangle2().pascalTriangle(3).toString());
	}
	
	public List<Integer> pascalTriangle(int n) {
		List<List<Integer>> fully = new ArrayList<>();
		List<Integer> res = new ArrayList<>();
//		if (n == 0)
//			return res;
		fully.add(new ArrayList<>());
		fully.get(0).add(1);
		n = n+1;
		for (int i = 1; i < n; i++) {
			List<Integer> curr = new ArrayList<>();
			List<Integer> prev = fully.get(i - 1);
			curr.add(1);
			for (int j = 1; j < i; j++) {
				curr.add(prev.get(j) + prev.get(j - 1));
			}
			curr.add(1);
			fully.add(curr);
		}
		res = fully.get(n-1);
		return res;
	}

}
