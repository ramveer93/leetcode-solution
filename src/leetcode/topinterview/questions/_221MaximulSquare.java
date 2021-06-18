package leetcode.topinterview.questions;

public class _221MaximulSquare {

	public static void main(String[] args) {

		char a[][] = { 
				{ '1', '0', '1', '0', '0' }, 
				{ '1', '0', '1', '1', '1' }, 
				{ '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' }

		};
		System.out.println(new _221MaximulSquare().maximalSquare(a));
	}

	/**
	 * https://www.youtube.com/watch?v=RElcqtFYTm0 
	 * 
	 * DP: if(a[i][j] == '0' )=>
	 * dp[i][j] = 0 else dp[i][j] = min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j]);
	 */
	public int maximalSquare(char[][] a) {

		int rows = a.length;
		if (rows == 0)
			return 0;
		int cols = a[0].length;
		int maxSquare = 0;
		int dp[][] = new int[rows + 1][cols + 1];

		for (int i = 0; i <= cols; i++) {
			dp[0][i] = 0;
		}
		for (int i = 0; i <= rows; i++) {
			dp[i][0] = 0;
		}

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if (a[i - 1][j - 1] == '0') {
					dp[i][j] = 0;
				} else {
					dp[i][j] = 1+Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
					if(dp[i][j]>maxSquare) {
						maxSquare = dp[i][j];
					}
					//maxSquare = Math.max(maxSquare, dp[i][j]);
				}

			}

		}

		return maxSquare * maxSquare;
	}
}
