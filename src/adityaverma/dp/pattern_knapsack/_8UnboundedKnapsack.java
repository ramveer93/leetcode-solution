package adityaverma.dp.pattern_knapsack;

public class _8UnboundedKnapsack {

	public static void main(String[] args) {
		int w = 10;
		int val[] = { 10, 40, 50, 70 };
		int wt[] = { 1, 3, 4, 5};
		System.out.println(new _8UnboundedKnapsack().recursion(wt, val, w, wt.length));
		System.out.println(new _8UnboundedKnapsack().dp(wt, val, w, wt.length));
	}

	public int recursion(int wt[], int val[], int w, int n) {
		if (w == 0 || n == 0)
			return 0;
		if (wt[n - 1] <= w) {
			return Math.max(val[n - 1] + recursion(wt, val, w - wt[n - 1], n), recursion(wt, val, w, n - 1));
		} else {
			return recursion(wt, val, w, n - 1);
		}
	}

	public int dp(int wt[], int val[], int w, int n) {
		int dp[][] = new int[n + 1][w + 1];
		/**initialization: w==0||n==0 return 0;
		 */
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (wt[i - 1] <= j) {
					dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][w];
	}
}
