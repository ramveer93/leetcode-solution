package adityaverma.dp.pattern_knapsack;

public class _10CoinChangeMaxNoOfWays {

	public static void main(String[] args) {
		int w[] = { 1, 2, 3 };
		int sum = 5;
		
		System.out.println(new _10CoinChangeMaxNoOfWays().coinChange1(w, sum, w.length));
	}

	/**
	 * we have to find no of ways to make coin of 5 using demonimations when there
	 * is infinite coin supply
	 */
	public int coinChange1(int w[], int sum, int n) {
		int dp[][] = new int[n + 1][sum + 1];

		/**
		 * initialization
		 * 
		 * when array empty and sum is empty: -> we have 1 way atleast
		 * 
		 * when array empty: but sum!=0 so total 0 ways
		 * 
		 * when array non empty: but sum==0 total ways 1
		 */

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0) {
					dp[i][j] = 0;
				}
				if (j == 0) {
					dp[i][j] = 1;
				}
			}
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (w[i - 1] <= j) {
					dp[i][j] = dp[i][j - w[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][sum];
	}
}
