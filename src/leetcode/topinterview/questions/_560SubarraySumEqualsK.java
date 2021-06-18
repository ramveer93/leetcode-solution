package leetcode.topinterview.questions;

import java.util.HashMap;
import java.util.Map;

public class _560SubarraySumEqualsK {
	
	public static void main(String[] args) {
		int a[] = {1,2,3};
		System.out.println(new _560SubarraySumEqualsK().subarraySum(a, 3));
	}
	


	/**
	 * https://www.youtube.com/watch?v=MHocw0bP1rA we will maintain a hashmap of key
	 * as cumulative sum(prefix sum) and value as its frequency
	 * 
	 *
	 */
	public int subarraySum(int a[], int k) {
		int result = 0;
		int sum = 0;// this is cumulative sum
		Map<Integer, Integer> cumulativeSum = new HashMap<>();
		cumulativeSum.put(0, 1);
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];// first calculate cumulative sum
			// check if sum-k exists in map or not
			if (cumulativeSum.containsKey(sum - k)) {
				result = result + cumulativeSum.get(sum-k);
			}
			cumulativeSum.put(sum, cumulativeSum.getOrDefault(sum, 0) + 1);
		}

		return result;

	}
}
