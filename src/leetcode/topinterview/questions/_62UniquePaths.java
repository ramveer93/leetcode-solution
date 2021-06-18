package leetcode.topinterview.questions;

public class _62UniquePaths {
	public static void main(String[] args) 
	{
		System.out.println(new _62UniquePaths().uniquePaths(1000,1));

	}
	
	
	public int uniquePathsRecursive(int m, int n) {
	    return uniquePathsHelper(m - 1, n - 1);
	  }
	  
	  private int uniquePathsHelper(int m, int n) {
	    if (m < 0 || n < 0) {
	      return 0;
	    } else if (m == 0 || n == 0) {
	      return 1;
	    } else {
	      return uniquePathsHelper(m - 1, n) + uniquePathsHelper(m, n - 1);
	    }
	  }
	

	/**
	 * https://www.youtube.com/watch?v=x6R3OQCYmHo
	 */
	public int uniquePaths(int m, int n) {
		if (m == 0 && n == 0)
			return 1;
		int dp[][] = new int[m][n];
		// first row to 1
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 1;

		}
		// first column to 1
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;

		}

		// fill other part with dp[i][j] = dp[i-1][j] +dp[i][j-1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

			}

		}

		return dp[m - 1][n - 1];

	}

}
