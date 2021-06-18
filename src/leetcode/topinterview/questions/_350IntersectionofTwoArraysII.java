package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _350IntersectionofTwoArraysII {

	public static void main(String[] args) {

		int a[] = {1,2,2,1};
		int b[] = {2,2};
		int k[] = new _350IntersectionofTwoArraysII().intersect(a, b);
		for(int i=0;i<k.length;i++) {
			System.out.println(k[i]);
			
		}
	}

	/**
	 * Need to find if b's elements are presnt in a
	 * 
	 */
	public int[] intersect(int a[], int b[]) {
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
		}

		for (int i = 0; i < b.length; i++) {
			if (map.containsKey(b[i]) && map.get(b[i]) > 0) {
				list.add(b[i]);
				map.put(b[i], map.get(b[i]) - 1);

			}

		}
		int res[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);

		}
		return res;

	}
}
