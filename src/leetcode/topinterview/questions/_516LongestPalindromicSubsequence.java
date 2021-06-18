package leetcode.topinterview.questions;

public class _516LongestPalindromicSubsequence {

	public static void main(String[] args) {

		System.out.println(new _516LongestPalindromicSubsequence().longestPalindromiicSubsequence("bbbab"));
	}

	/**
	 * dp[i][j]: the longest palindromic subsequence's length of substring(i, j),
	 * here i, j represent left, right indexes in the string State transition:
	 * dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j) otherwise, dp[i][j]
	 * = Math.max(dp[i+1][j], dp[i][j-1]) Initialization: dp[i][i] = 1
	 * 
	 * 
	 * https://www.youtube.com/watch?v=_nCsPn7_OgI if(s.[i] == s[j] => T[i][j] =
	 * T[i+1][j-1]+2; else{ T[i][j] = max(T[i+1][j], T[i][j-1]); }
	 * 
	 * 
	 * 
	 * 
	 * We can solve this in another way also : 
	 * 
	 * https://www.youtube.com/watch?v=J7rqc7pbwkI&list=PLzffTJx5aHaT-0K_b47KxScckZfDXAKF3&index=6
	 * 
	 * same as _1143
	 * 
	 * 
	 */
	public int longestPalindromiicSubsequence(String s) {
		if (s.length() == 0)
			return 0;
		int n = s.length();
		int dp[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;

		}

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i<n-l+1; i++) {
				int j = i+l-1;
				if(l == 2 && s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 2;
				}else if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 2 + dp[i + 1][j - 1];

				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}

			}

		}

		return dp[0][n - 1];
	}
}
