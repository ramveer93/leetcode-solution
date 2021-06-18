package leetcode.topinterview.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class _136SingleNumber {

	public static void main(String[] args) {
		int a[] = { 4, 1, 2, 1, 2 };
		System.out.println(new _136SingleNumber().singleNumber(a));
		System.out.println(new _136SingleNumber().solveXor(a));

	}

	/**
	 * 
	 * O(n) time O(n) space
	 */
	public int singleNumber(int a[]) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);

			} else {
				map.put(a[i], 1);
			}
		}
		for (Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() == 1) {
				return e.getKey();

			}

		}

		return 0;
	}

	/**
	 * 
	 * 0 XOR a = a
	 * a XOR a = 0
	 */
	public int solveXor(int a[]) 
	{
		int number = 0;
		for(int i=0;i<a.length;i++)
		{
			number = number^a[i];
			
		}

		return number;
	}
}
