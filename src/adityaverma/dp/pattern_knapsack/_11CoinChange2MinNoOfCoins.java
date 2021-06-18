package adityaverma.dp.pattern_knapsack;

public class _11CoinChange2MinNoOfCoins {

	public static void main(String[] args) {
		int w[] = { 9, 6, 5, 1 };
		int sum = 89;

		System.out.println(new _11CoinChange2MinNoOfCoins().coinChangeDp(w, sum, w.length));
	}

	/**
	 * We need to find min no of coins to make the sum
	 */
	public int coinChangeDp(int w[], int sum, int n) {

		int dp[][] = new int[n + 1][sum + 1];
		/**
		 * 1. first row: sum=0 and and no coin: Integer_MAX_VALUE-1
		 * 
		 * 2. first col: sum = 0 and coins not empty-> 0
		 */

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0) {
					dp[i][j] = Integer.MAX_VALUE - 1;
				}
				if (j == 0) {
					dp[i][j] = 0;
				}
			}

		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (w[i - 1] <= j) {
					dp[i][j] = Math.min(1 + dp[i][j - w[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}

		}

		return dp[n][sum];

	}

}
