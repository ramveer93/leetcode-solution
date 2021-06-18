package adityaverma.dp.pattern_longes.common.subsequence;

public class PrintLongestCommonSubsequence {

	public static void main(String[] args) {

		String x = "bchjk";
		String y = "abkjk";
		System.out.println(new PrintLongestCommonSubsequence().printLCS(x, y, x.length(), y.length()));
	}

	/**
	 * String x: abcfgh String y: abkldhk
	 * 
	 * 
	 */
	public int lcsRecursion(String x, String y, int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return 1 + lcsRecursion(x, y, m - 1, n - 1);
		} else {
			return Math.max(lcsRecursion(x, y, m, n - 1), lcsRecursion(x, y, m - 1, n));
		}

	}

	public int dpLcs(String x, String y, int m, int n) {
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}

			}

		}

		return dp[m][n];
	}

	/**
	 * https://www.youtube.com/watch?v=x5hQvnUcjiM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=23
	 * 
	 * 
	 * First start from m,n index of dp see if x[i-1]==y[j-1]=> 
	 * if yes then move to i-1,j-1 if not then move to direction of max
	 */
	public String printLCS(String x, String y, int m, int n) {
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}

			}

		}

		int i = m;
		int j = n;
		String result = "";
		while (i > 0 && j > 0) {
			if (x.charAt(i - 1) == y.charAt(j - 1)) {
				result = result + x.charAt(i - 1);
				i--;
				j--;
			} else {
				if (dp[i][j - 1] > dp[i - 1][j]) {
					j--;

				} else {
					i--;
				}
			}

		}
		StringBuffer sb = new StringBuffer(result);
		return sb.reverse().toString();

	}
}
