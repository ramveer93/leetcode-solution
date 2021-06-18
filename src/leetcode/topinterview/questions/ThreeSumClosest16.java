package leetcode.topinterview.questions;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=qBr2hq4daWE
 * 
 * @param args
 */

public class ThreeSumClosest16 {
	public static void main(String[] args) {
		int a[] = { -1, 2, 1, -4 };
		System.out.println(threeSumClosest(a, 1));

	}

	public static int threeSumClosest(int a[], int target) {
		if (a.length < 3)
			return 0;
		Arrays.sort(a);

		int result = a[0] + a[1] + a[a.length - 1];
		for (int i = 0; i < a.length - 2; i++) {
			int j = i + 1;
			int k = a.length - 1;
			while (j < k) {
				int currentSum = a[i] + a[j] + a[k];
				if (currentSum > target) {
					k--;

				} else {
					j++;
				}
				if (Math.abs(currentSum - target) < Math.abs(result - target)) {
					result = currentSum;

				}

			}

		}
		return result;

	}

}
