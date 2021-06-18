package leetcode.topinterview.questions;

public class _64MinPathSum {

	public static void main(String[] args) {

		int a[][] = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(new _64MinPathSum().minPathSum(a));
	}

	/**
	 * 
	 * 
	 * https://www.youtube.com/watch?v=MfRShRkYgSU&list=PLzffTJx5aHaT-0K_b47KxScckZfDXAKF3&index=3
	 * 
	 * 
	 * 
	 * https://www.youtube.com/watch?v=t1shZ8_s6jc&t=584s
	 * 
	 */
	public int minPathSum(int a[][]) {
		int row = a.length;
		if (row == 0)
			return 0;
		int col = a[0].length;
		int dp[][] = new int[row][col];
		dp[0][0] = a[0][0];
		// fill the first row
		for (int i = 1; i < col; i++) {
			dp[0][i] = dp[0][i - 1] + a[0][i];

		}

		for (int i = 1; i < row; i++) {// first column
			dp[i][0] = dp[i - 1][0] + a[i][0];

		}

		// fill rest of the table
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = a[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);

			}
		}

		return dp[row - 1][col - 1];
	}
}
