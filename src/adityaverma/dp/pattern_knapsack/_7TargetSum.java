package adityaverma.dp.pattern_knapsack;

/**
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

	Input: nums is [1, 1, 1, 1, 1], S is 3. 
	Output: 5
	Explanation: 
	
	-1+1+1+1+1 = 3
	+1-1+1+1+1 = 3
	+1+1-1+1+1 = 3
	+1+1+1-1+1 = 3
	+1+1+1+1-1 = 3
 *
 */
public class _7TargetSum {

	public static void main(String[] args) {
		int w[] = {1,1,2,3};
		
		System.out.println(new _7TargetSum().targetSum(w, 1, w.length));
	}
	
	/**
	 * Find the no of subsets from w such that we can partition the w in s1 and s2 such that s1-s2=sum 
	 * and we need to replace +/- before each number 
	 * 
	 * 
	 * 
	 * Its the same problem as count no of subsets with given difference
	 * 
	 * s1-s2 = diff
	 * s1+s2 = sum
	 * 2s1 = diff+sum
	 * s1 = (diff+sum)/2;
	 * so we need to find the ways such that s1 sum exists in w
	 */
	public int targetSum(int w[], int sum, int n) {
		
		int totalSum = 0;
		for(int i=0;i<n;i++)totalSum+=w[i];
		
		int s1 = (sum+totalSum)/2;
		
		int[][]dp = new int[n+1][s1+1];
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(i==0)dp[i][j] = 0;
				if(j==0)dp[i][j] = 1;
				
			}
			
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(w[i-1]<=j) {
					dp[i][j] = dp[i-1][j-w[i-1]]+dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j];
				}
				
			}
			
		}
		
		return dp[n][s1];
	}
}
