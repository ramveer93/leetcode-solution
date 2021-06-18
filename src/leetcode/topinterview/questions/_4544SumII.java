package leetcode.topinterview.questions;

import java.util.HashMap;
import java.util.Map;

public class _4544SumII {

	public static void main(String[] args) {

	}

	/**
	 * https://leetcode.com/problems/4sum-ii/discuss/93920/Clean-java-solution-O(n2)
	 * 
	 */
	public int fourSumCount(int a[], int b[], int c[], int d[]) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();// key will be sum and value will be how many time same sum is
													// coming
		// A[a]+B[b]+C[c]+D[d] = 0=> A[a]+B[b] = -(C[c]+D[d])
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				int sum = a[i] + b[j];
				map.put(sum, map.getOrDefault(sum, 0) + 1);// if same sum comes again increment the value

			}

		}

		for (int k = 0; k < c.length; k++) {
			for (int l = 0; l < d.length; l++) {
				int sum = -c[k] - d[l];
				res = res + map.getOrDefault(sum, 0);

			}

		}

		return res;
	}

}
