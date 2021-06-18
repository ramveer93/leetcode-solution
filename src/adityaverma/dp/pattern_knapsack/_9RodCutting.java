package adityaverma.dp.pattern_knapsack;

public class _9RodCutting {

	public static void main(String[] args) {
		int w = 8;
		int n = 8;
		int length[] = {1,   2,   3,   4,   5,   6,   7,   8 };
		int price[] = {1 ,  5  , 8 ,  9 , 10 , 17 , 17 , 20};
		System.out.println(new _9RodCutting().dp(price, length, w, n));
		
	}

	/**
	 * w: total length of the rod 
	 * length[]: length of the cut rod 
	 * price[]: profit if
	 * we cut the rod with this much length
	 * 
	 * we have to maximize the profit
	 * 
	 * https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14
	 * 
	 * 
	 * price-> val wt-> length
	 */
	public int dp(int price[], int length[], int w, int n) {
		int dp[][] = new int[n + 1][w + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;

			}

		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (length[i - 1] <= j) {
					dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}

		}

		return dp[n][w];

	}
}
