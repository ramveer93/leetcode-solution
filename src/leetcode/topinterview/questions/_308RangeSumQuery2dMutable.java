package leetcode.topinterview.questions;

public class _308RangeSumQuery2dMutable {

	private int dp[][];

	public _308RangeSumQuery2dMutable(int[][] matrix) {
		int row = 0;
		int col = 0;
		if (matrix.length != 0) {
			row = matrix.length;
			col = matrix[0].length;
		}
		dp = new int[row + 1][col + 1];
		// fill the matrix
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i - 1][j - 1] - dp[i - 1][j - 1];

			}

		}

	}

	/**
	 * https://www.youtube.com/watch?v=PwDqpOMwg6U
	 * 
	 * dp[i][j]  will represent the rectangle sstarting from 00 to i , j 
	 */
	public int sumRange(int row1, int col1, int row2, int col2) {

		row1++;
		col1++;
		row2++;
		col2++;
		return dp[row2][col2] - dp[row1 - 1][col2] - dp[row2][col1 - 1] + dp[row1 - 1][col1 - 1];
	}
}
