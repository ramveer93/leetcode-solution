package leetcode.topinterview.questions;

public class _72EditDistance {

	public static void main(String[] args) {

		System.out.println(new _72EditDistance().minDistance("intention", "execution"));
	}

	/**
	 * 
	 * https://www.youtube.com/watch?v=We3YDTzNXEk
	 * 
	 * 
	 * 
	 * 
	 * if s[i] == s[j] => t[i][j] = t[i-1][j-1]; else t[i][j] = min(t[i][j-1],
	 * t[i-1][j-1], t[i-1][j]);
	 * 
	 */
	public int minDistance(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();

		if (s1.equals(s2)) {
			return 0;
		}
		if (n1 == 0 || n2 == 0) {
			return Math.abs(n1 - n2);

		}
		int dp[][] = new int[n1 + 1][n2 + 1];
		// if n1 = 0 then no of operations needed to convert s2 to s1 will be n2
		for (int i = 0; i < dp[0].length; i++) { // fill first row
			dp[0][i] = i;
		}

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i; // fill first column

		}

		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
				}

			}

		}

		return dp[n1][n2];

	}
}
