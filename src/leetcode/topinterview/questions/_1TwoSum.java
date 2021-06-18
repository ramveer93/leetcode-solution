package leetcode.topinterview.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1TwoSum {
	public static void main(String[] args) {

	}

	public static int[] twoSum(int a[], int target) throws Exception {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			int complement = target - a[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(a[i], i);

		}
		throw new Exception("No solution");
	}

	public static int[] twoSumTwoPointers(int a[], int t) throws Exception {
		Arrays.sort(a);
		int low = 0, high = a.length - 1;
		while (low < high) {
			if (a[low] + a[high] == t) {
				return new int[] { a[low], a[high] };
			} else if (a[low] + a[high] > t) {
				high--;
			} else {
				low++;
			}
		}
		throw new Exception("No answer");
	}

}
