package adityaverma.dp.pattern_longes.common.subsequence;

public class ShortestCommonSuperSequence {

	public static void main(String[] args) {
		String x = "AGGTAB";
		String y = "GXTXAYB";
		
		System.out.println(new ShortestCommonSuperSequence().shortestCommonSuperSequence(x, y, x.length(), y.length()));
	}

	/**
	 * Question: generate a string from x and y which have both sequences 
	 * e.g: x = geek
	 *      y: eke
	 *       now the simplest result can be x+y = geekeke but this is not shortest 
	 *       as we are repeating some characters unnecessary 
	 *       
	 *       So what we can do we can merge both strings and - the lcs of both strings
	 *       
	 * Idea is to merge both x and y and remove chars which are coming in lcs res =
	 * length of x+y-lcs
	 *
	 */
	public int shortestCommonSuperSequence(String x, String y, int m, int n) {
		int dp[][] = new int[m + 1][n + 1];
		/**
		 * initialize it with 0
		 */
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
		return (x + y).length() - lcs;
	}
	
}
