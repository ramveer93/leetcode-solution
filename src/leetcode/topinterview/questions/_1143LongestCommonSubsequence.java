package leetcode.topinterview.questions;

public class _1143LongestCommonSubsequence {

	public static void main(String[] args) {

		System.out.println(new _1143LongestCommonSubsequence().recusrive("abcde", "ace"));
		
		System.out.println(new _1143LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace"));
		
	}
	

	/**
	 * https://www.youtube.com/watch?v=YL3b3F7sJBM&list=PLzffTJx5aHaT-0K_b47KxScckZfDXAKF3&index=7
	 * 
	 * DP:
	 * 
	 * first row and column will be 0 because if one of the string is empty ,lcs
	 * will be 0
	 * 
	 * if s1[i] == s2[j] dp[i][j] = 1+dp[i-1][j-1] else dp[i][j] =
	 * Math.max(dp[i-1][j],dp[i][j-1]);
	 *
	 */
	public int longestCommonSubsequence(String s1, String s2) {

		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 0;

		}

		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 0;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}

			}

		}

		return dp[s1.length()][s2.length()];
	}

	public int recusrive(String s1, String s2) {

		int dp[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;

			}

		}
		return helper(s1, s2, 0, 0, dp);
	}

	private int helper(String s1, String s2, int i, int j, int dp[][]) {

		if (i > s1.length() - 1 || j > s2.length() - 1)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];
		if (s1.charAt(i) == s2.charAt(j)) { // if both char are same move both char length
			return dp[i][j] = 1 + helper(s1, s2, i + 1, j + 1, dp);

		} else { // first move i then j and find optimal result out of that
			return dp[i][j] = Math.max(helper(s1, s2, i + 1, j, dp), helper(s1, s2, i, j + 1, dp));
		}

	}
}
