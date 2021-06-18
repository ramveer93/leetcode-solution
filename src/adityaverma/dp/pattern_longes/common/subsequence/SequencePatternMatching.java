package adityaverma.dp.pattern_longes.common.subsequence;

public class SequencePatternMatching {

	public static void main(String[] args) {

		String x = "axy";
		String y = "aoxcpy";
		System.out.println(new SequencePatternMatching().seqPatternMatching(x, y, x.length(), y.length()));
	}

	/**
	 * x: axy y: aoxcpy
	 * 
	 * find out if x exists in y in a subsequence or not 
	 * 
	 * If we calculate lcs(x,y) then if length of lcs = length of x then the string 
	 * x is present in y as a subsequence else not
	 * 
	 */
	public boolean seqPatternMatching(String x, String y, int m, int n) {
		int dp[][] = new int[m+1][n+1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];

				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}

			}

		}
		int lcs = dp[m][n];
		return lcs == x.length();
	}
}
