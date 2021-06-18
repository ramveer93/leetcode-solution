package adityaverma.dp.pattern_longes.common.subsequence;

public class _1LongestCommonSubsequence {

	private static int[][] t;

	public static void main(String[] args) {
		String x = "abcdfh";
		String y = "abhcd";
		t = new int[x.length() + 1][y.length() + 1];
		// Arrays.fill(t, -1);
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j] = -1;

			}

		}

		System.out.println(new _1LongestCommonSubsequence().lcsRecursion(x, y, x.length(), y.length()));
		System.out.println(new _1LongestCommonSubsequence().lcsBottomUp(x, y, x.length(), y.length()));
		System.out.println(new _1LongestCommonSubsequence().lcsdp(x, y, x.length(), y.length()));
		
	}

	/**
	 * base condition choice diagram minimize the input
	 * 
	 */
	public int lcsRecursion(String x, String y, int n, int m) {
		if (n == 0 || m == 0)
			return 0;
		if (x.charAt(n - 1) == y.charAt(m - 1)) {
			return 1 + lcsRecursion(x, y, n - 1, m - 1);
		} else {
			return Math.max(lcsRecursion(x, y, n - 1, m), lcsRecursion(x, y, n, m - 1));
		}
	}

	/**
	 * how to know size of table dp: take variables which are changing in recursion
	 * 
	 * 
	 * when to use n+1 or n : if we have given the input of n then we have to store
	 * n+1 so that we can store the limit till n
	 * 
	 * 
	 * 
	 * https://www.youtube.com/watch?v=g_hIx4yn9zg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=20
	 * 
	 * 
	 * we can apply dp only when there are more than 3 recursion calls
	 */
	public int lcsBottomUp(String x, String y, int n, int m) {
		if (n == 0 || m == 0)
			return 0;
		if (t[n][m] != -1)
			return t[n][m];

		if (x.charAt(n - 1) == y.charAt(m - 1)) {
			return t[n][m] = 1 + lcsBottomUp(x, y, n - 1, m - 1);
		} else {
			return t[n][m] = Math.max(lcsBottomUp(x, y, n, m - 1), lcsBottomUp(x, y, n - 1, m));
		}
	}

	public int lcsdp(String x, String y, int n, int m) {
		/**
		 * initialize
		 */
		int dp[][] = new int[n + 1][m + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0)
					dp[i][j] = 0;
				if (j == 0)
					dp[i][j] = 0;
			}
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}

			}

		}
		
		return dp[n][m];
	}

}
