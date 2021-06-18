package leetcode.topinterview.questions;

import java.util.Arrays;

public class _213HouseRobberII {

	public static void main(String[] args) {

	}

	public int rob(int a[]) {
		if (a.length == 0)
			return 0;
		if (a.length == 1)
			return a[0];
		int dp[] = new int[a.length];
		Arrays.fill(dp, -1);
		int robFirst = helper(a, dp, 2, a.length - 2);
		Arrays.fill(dp, -1);
		int dontRobFirst = helper(a, dp, 1, a.length - 1);
		return Math.max(robFirst, dontRobFirst);

	}

	public int helper(int a[], int dp[], int start, int end) {
		if (start > end) {
			return 0;

		}
		if (start == end) {
			return a[end];
		}
		if (dp[start] != 0) {
			return dp[start];

		} else {
			int rob = a[start] + helper(a, dp, start + 2, end);
			int dontRob = helper(a, dp, start + 1, end);
			return dp[start] = Math.max(rob, dontRob);
		}

	}
}
