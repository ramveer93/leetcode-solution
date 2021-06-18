package adityaverma.dp.pattern_knapsack;

public class _3EqualSumPartition {

	public static void main(String[] args) {
		int w[] = { 1, 5, 5, 11 };

		System.out.println(new _3EqualSumPartition().recursion(w, w.length));
		System.out.println(new _3EqualSumPartition().dp(w, w.length));
	}

	/**
	 * 
	 * https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8
	 * 
	 * Find if the given array can be partition into two equal sums
	 * 
	 */
	public boolean recursion(int w[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += w[i];
		}
		if (sum % 2 != 0)
			return false;// if sum is odd
		else
			return subsetsum(w, sum / 2, n);
	}

	private boolean subsetsum(int[] w, int sum, int n) {
		if (sum == 0)
			return true;
		if (n == 0)
			return false;
		if (w[n - 1] <= sum) {
			return subsetsum(w, sum - w[n - 1], n - 1) || subsetsum(w, sum, n - 1);
		} else
			return subsetsum(w, sum, n - 1);
	}

	public boolean dp(int w[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += w[i];
		if (sum % 2 != 0)
			return false;
		int newSum = sum / 2;

		boolean dp[][] = new boolean[n + 1][newSum + 1]; // n->i, newSum->j
		// initialization
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0) { // first col
					dp[i][j] = false;
				}
				if (j == 0)
					dp[i][j] = true;
			}
		}
		dp[0][0] = true;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (w[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - w[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][newSum];
	}
}
