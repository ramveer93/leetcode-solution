package leetcode.topinterview.questions;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target,
 * S. Now you have 2 symbols + and -. For each integer, you should choose one
 * from + and - as its new symbol.
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.
 * 
 * Example 1:
 * 
 * Input: nums is [1, 1, 1, 1, 1], S is 3. Output: 5 Explanation:
 * 
 * -1+1+1+1+1 = 3 +1-1+1+1+1 = 3 +1+1-1+1+1 = 3 +1+1+1-1+1 = 3 +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * 
 * 
 * Constraints:
 * 
 * The length of the given array is positive and will not exceed 20. The sum of
 * elements in the given array will not exceed 1000. Your output answer is
 * guaranteed to be fitted in a 32-bit integer.
 * 
 * @author sramveer
 *
 */
public class _494TargetSum {

	public static void main(String[] args) {

		int a[] = { 0,0,0,0,0,0,0,0,1};
		System.out.println(new _494TargetSum().findTargetSumWays(a, 1));
	}

	/**
	 * https://www.youtube.com/watch?v=hqGa65Rp5LQ
	 * 
	 * this is same as _416 subset sum , but here we have to return the count not
	 * the boolean
	 * 
	 * 
	 * https://www.youtube.com/watch?v=MqYLmIzl8sQ
	 * 
	 * 
	 */

	/**
	 * https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C%2B%2B-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation
	 * 
	 */
	public int findTargetSumWays(int[] nums, int s) {
		int sum = 0;
		for (int n : nums)
			sum += n;
		return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) /2);
	}

	
	public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1]; 
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n]; 
        return dp[s];
    } 
	
	
	/**
	 * https://www.youtube.com/watch?v=34l1kTIQCIA
	 */
	public int subsetSumDP(int set[], int sum) {
		int n = set.length;
		int dp[][] = new int[n + 1][sum + 1];
		// x axis(columns) -> sum
		// y axis(rows) -> index of sets
		// first we can make a sum 0 by any index so first column will have values as
		// true
		// now can we make sum as i , by 0 elements , No , so first row will have false
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = 0;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j < set[i - 1]) { // i is index of set and j is sum
					dp[i][j] = dp[i - 1][j];
				}
				if (j >= set[i - 1]) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - set[i - 1]];
				}

			}
		}

		return dp[n][sum];
	}

}
