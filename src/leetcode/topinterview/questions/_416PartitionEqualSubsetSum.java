package leetcode.topinterview.questions;

public class _416PartitionEqualSubsetSum {

	public static void main(String[] args) {

		/**
		 * 0-1 knapsack problem
		 */

		int profit[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };
		int totalWeight = 50;
		System.out.println(new _416PartitionEqualSubsetSum().knapsack(profit, wt, totalWeight));
		System.out.println(new _416PartitionEqualSubsetSum().knapsackDp(profit, wt, totalWeight));

		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		System.out.println(new _416PartitionEqualSubsetSum().subsetSumDP(set, sum));
	}

	public boolean canPartitionBruteForce(int nums[]) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++)
			sum += nums[i];
		if (sum % 2 != 0)
			return false;
		int subsetSum = sum / 2;
		int n = nums.length;

		return dfs(nums, n - 1, subsetSum);
	}

	public boolean dfs(int a[], int n, int subsetSum) {
		if (subsetSum == 0)
			return true;
		if (subsetSum < 0 || n == 0)
			return false;

		return dfs(a, n - 1, subsetSum) || dfs(a, n - 1, subsetSum - a[n - 1]);
	}

	/**
	 * https://www.youtube.com/watch?v=obhWqDfzwQQ&t=8s
	 */
	public boolean canPartitionDP(int a[]) {

		int sum = 0;
		for (int i = 0; i < a.length; i++)
			sum += a[i];
		if (sum % 2 != 0)
			return false;
		int subsetSum = sum / 2;
		int n = a.length;
		// now this is a problem of subset sum , if there is a subset which have the sum
		// as subset sum or not

		boolean dp[][] = new boolean[n + 1][subsetSum + 1];
		for (int i = 0; i < dp.length; i++)
			dp[i][0] = true;

		for (int i = 1; i < dp[0].length; i++)
			dp[0][i] = false;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j < a[i - 1])
					dp[i][j] = dp[i - 1][j];// skip this
				if (j >= a[i - 1])
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - a[i - 1]];
			}
		}

		return dp[n][subsetSum];
	}

	/**
	 * knapsack problem you have given array of weights and profit and total weight
	 * of knapsack, find max profit
	 * 
	 * weights[]: 1 2 3 profit[]: 2 3 5 total weight: 4
	 * 
	 * So total profit can be 5+2 = 7
	 * 
	 * 
	 * Recursive solution:
	 * 
	 * Base case: If there is no place left in bag then we can't have any profit :
	 * w==0-> profit =>0 If there is no item in the bag them we can't have any
	 * profit : n==0->profit=>0
	 * 
	 * 
	 * if current weight of item >total weight: then we can't include this if the
	 * current weight of the item <=total weight then we have two choices: either
	 * include this or dont include this
	 * 
	 */

	public int knapsack(int profit[], int wt[], int weight) {
		int n = wt.length - 1;
		return helper(profit, wt, weight, n);
	}

	private int helper(int[] profit, int[] wt, int weight, int n) {
		// base case:
		if (n == 0 || weight == 0)
			return 0;
		else if (wt[n] > weight) {
			return helper(profit, wt, weight, n - 1);
		} else {
			return Math.max(helper(profit, wt, weight, n - 1), profit[n] + helper(profit, wt, weight - wt[n], n - 1));
		}
	}

	/**
	 * https://www.youtube.com/watch?v=l4lsRYNS_ok&list=PLzffTJx5aHaT-0K_b47KxScckZfDXAKF3&index=20
	 * 
	 * 
	 * 
	 * https://www.youtube.com/watch?v=WNkqbqyvR_0
	 */
	public int knapsackDp(int profit[], int wt[], int totalWeight) {
		int n = profit.length; // rows
		int dp[][] = new int[n + 1][totalWeight + 1];
		// i -> item no , j-> weight
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= totalWeight; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;// i==0 means there is no item left, j==0 means no space in bag,
				else if (wt[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], profit[i - 1] + dp[i - 1][j - wt[i - 1]]);
				}
			}
		}

		return dp[n][totalWeight];
	}

	/**
	 * https://www.youtube.com/watch?v=34l1kTIQCIA
	 */
	public boolean subsetSumDP(int set[], int sum) {
		int n = set.length;
		boolean dp[][] = new boolean[n + 1][sum + 1];
		// x axis(columns) -> sum
		// y axis(rows) -> index of sets
		// first we can make a sum 0 by any index so first column will have values as
		// true
		// now can we make sum as i , by 0 elements , No , so first row will have false
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = false;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j < set[i - 1]) { // i is index of set and j is sum
					dp[i][j] = dp[i - 1][j];
				}
				if (j >= set[i - 1]) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
				}

			}
		}

		return dp[n][sum];
	}
}
