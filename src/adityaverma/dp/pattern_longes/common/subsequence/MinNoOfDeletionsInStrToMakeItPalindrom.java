package adityaverma.dp.pattern_longes.common.subsequence;

public class MinNoOfDeletionsInStrToMakeItPalindrom {

	public static void main(String[] args) {
		String x = "agbcba";
		System.out.println(new MinNoOfDeletionsInStrToMakeItPalindrom().minNoOfDeletionsToMakeItPalindrom(x));
	}

	/**
	 * we can minimize deletiongs only when palindromic subsequence is longest so
	 * String x = agbcba we can calculate longest palindrom sub sequence from x ,
	 * which will be : abcba now we can calculate min no of deletions = x.leng - lps
	 */
	public int minNoOfDeletionsToMakeItPalindrom(String x) {
		String y = new _3LongestPalindromicSubsequence().reverse(x);
		int m = x.length();
		int n = y.length();

		int dp[][] = new int[m + 1][n + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}

			}

		}

		int lps = dp[m][n];
		int minDeletions = x.length() - lps;
		return minDeletions;

	}
}
