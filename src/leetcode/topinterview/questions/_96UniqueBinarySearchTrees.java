package leetcode.topinterview.questions;

public class _96UniqueBinarySearchTrees {

	public static void main(String[] args) {

		System.out.println(new _96UniqueBinarySearchTrees().numTrees(40));
		System.out.println(new _96UniqueBinarySearchTrees().recursive(40));
	}

	/**
	 * https://www.youtube.com/watch?v=OIc0mHgHUww
	 * 
	 * https://www.youtube.com/watch?v=CMaZ69P1bAc
	 * 
	 * catalon number(n) = c(i)*c(n-i-1) c(0) = c(1) = 1;
	 *
	 */
	public int numTrees(int n) {
		int dp[] = new int[n + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}

		}
		return dp[n];
	}

	public int recursive(int n) {
		if (n == 0 || n == 1)
			return 1;
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += recursive(i) * recursive(n - i - 1);
		}

		return result;

	}
}
