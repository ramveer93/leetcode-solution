package adityaverma.dp.pattern_knapsack;

/**
 * Given a set of non-negative integers, 
 * and a value sum, determine if there is a subset of the given 
 * set with sum equal to given sum. 

Example: 

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True  
There is a subset (4, 5) with sum 9.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
There is no subset that add up to 30.
 * @author sramveer
 *
 */
public class _2SubsetSum {

	private static int[][] t;

	public static void main(String[] args) {
//		int w[] = {};
//		int n = 0;
//		int sum = 0;
//		t = new int[n + 1][sum + 1];
//		Arrays.fill(t, -1);
		
		int a[] = {68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46};
		int b = 282;
		
//		t = new int[a.length + 1][b + 1];
//		Arrays.fill(t, -1);
		
		System.out.println(new _2SubsetSum().dp(a, b, a.length));

	}

	/**
	 * How to identify if it is knapsack: 
	 * here also we have choice : either to chose
	 * or not chose current element
	 * 
	 * what is changin from knapsack: 
	 * 1. return from int to boolean 
	 * 2. instead of max -> we need or
	 */
	public boolean subsetSum(int w[], int sum, int n) {
		if (sum == 0)
			return true;
		else if (n == 0)
			return false;
		if (w[n - 1] <= sum) {
			return subsetSum(w, sum - w[n - 1], n - 1) || subsetSum(w, sum, n - 1);
		} else { // w[n-1]>sum-> dont include
			return subsetSum(w, sum, n - 1);

		}
	}

	public boolean subsetsumMemization(int w[], int sum, int n) {
		if (sum == 0)
			return true;
		if (n == 0)
			return false;
		if (t[n][sum] != -1) {
			return t[n][sum] == 1 ? true : false;
		}
		if (w[n - 1] <= sum) {
			t[n][sum] = (subsetsumMemization(w, sum - w[n - 1], n - 1) || subsetsumMemization(w, sum, n - 1)) == true
					? 1
					: 0;
			return t[n][sum] == 1 ? true : false;
		} else {
			t[n][sum] = (subsetsumMemization(w, sum, n - 1)) == true ? 1 : 0;
			return t[n][sum] == 1 ? true : false;
		}
	}

	public boolean dp(int w[], int sum, int n) {
		// initialization
		int dp[][] = new int[n + 1][sum + 1];
		dp[0][0] = 1;
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
				if (w[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - w[i - 1]] , dp[i - 1][j]);
				}
			}

		}

		return dp[n][sum]==1?true:false;

	}
}
