package adityaverma.dp.pattern_longes.common.subsequence;

public class PrintShortestCommonSuperSequence {

	public static void main(String[] args) {
		String x = "AGGTAB";
		String y = "GXTXAYB";
		System.out.println(new PrintShortestCommonSuperSequence().printSCS(x, y, x.length(), y.length()));
	}

	/**
	 * String x = "AGGTAB"; String y = "GXTXAYB"; Idea is to merge 
	 * both x and y and
	 * remove chars which are coming in lcs res = length of x+y-lcs
	 * 
	 * will have to print this scs
	 * 
	 */
	public String printSCS(String x, String y, int m, int n) {
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

		int i = m;
		int j = n;
		String res = "";

		while (i > 0 && j > 0) {
			if (x.charAt(i - 1) == y.charAt(j - 1)) {
				res += x.charAt(i - 1);
				i--;
				j--;
			} else {
				if (dp[i - 1][j] > dp[i][j - 1]) {
					res += x.charAt(i - 1);
					i--;
				} else {
					res += y.charAt(j - 1);
					j--;
				}
			}
		}

		while (i > 0) {
			res += x.charAt(i);
			i--;

		}

		while (j > 0) {
			res += y.charAt(j--);

		}

		// System.out.println(res);

		return res;

	}
}
