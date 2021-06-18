package adityaverma.dp.pattern_knapsack;

public class _4CountOfsubsetsumWithGivenSum {

	public static void main(String[] args) {
		int w[] = { 2, 3, 5, 6, 8, 10 };
		System.out.println(new _4CountOfsubsetsumWithGivenSum().recursion(w, 10, w.length));
		System.out.println(new _4CountOfsubsetsumWithGivenSum().dp(w, 10, w.length));

	}

	public int recursion(int w[], int sum, int n) {
		if (sum == 0)
			return 1;
		if (n == 0)
			return 0;
		if (w[n - 1] <= sum) {
			return recursion(w, sum - w[n - 1], n - 1) + recursion(w, sum, n - 1);
		} else {
			return recursion(w, sum, n - 1);
		}
	}

	public int dp(int w[], int sum, int n) {
		int dp[][] = new int[n + 1][sum + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0)
					dp[i][j] = 0;
				if (j == 0)
					dp[i][j] = 1;
			}
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (w[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - w[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}

		}

		return dp[n][sum];

	}
}
