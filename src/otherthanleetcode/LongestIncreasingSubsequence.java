package otherthanleetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int a[] = { 3, 4, 2, 5, 1 };
		System.out.println(new LongestIncreasingSubsequence().lis(a));

	}

	/**
	 * 
	 * 
	 * https://www.youtube.com/watch?v=CE2b_-XfVDk
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param a
	 * @return
	 */
	public int lis(int a[]) {
		int dp[] = new int[a.length];
		Arrays.fill(dp, 1);

		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			if (max < dp[i]) {
				max = dp[i];
			}

		}
		int ans;
		int elementsToBeRemoved = a.length - max;
		if (elementsToBeRemoved == 0) {
			ans = 0;
		} else {
			ans = elementsToBeRemoved - 1;
		}
		System.out.println("how many elements need to remove to make array increasingly sorted: " + ans);
		return max;

	}

	private int bs(int a[], int low, int high, int x) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (a[mid] == x) {
				return mid;
			} else if (a[mid] > x) {
				high = mid - 1;

			} else {
				low = mid + 1;
			}

		}
		return low;
	}

	public int lisOptimized(int a[]) {
		int n = a.length;
		int len = 0;
		int dp[] = new int[n];
		dp[len++] = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] > dp[len - 1]) {
				dp[len++] = a[i];

			} else {
				int pos = bs(dp, 0, len - 1, a[i]);
				dp[pos] = a[i];
			}

		}
		return len;

	}
}
