package leetcode.topinterview.questions;

public class _304RangeSumQuery2DImmutable {
	private int dp[][];

	public _304RangeSumQuery2DImmutable(int[][] matrix) {
		int row = 0;
		int col = 0;
		if (matrix.length != 0) {
			row = matrix.length;
			col = matrix[0].length;
		}
		dp = new int[row + 1][col + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i - 1][j - 1] - dp[i - 1][j - 1];

			}

		}

	}

	public static void main(String[] args) {

	}

	/**
	 * https://www.youtube.com/watch?v=PwDqpOMwg6U
	 */
	public int sumRegion(int row1, int col1, int row2, int col2) {
		row1++;
		col1++;
		row2++;
		col2++;
		return dp[row2][col2] - dp[row1 - 1][col2] - dp[row2][col1 - 1] + dp[row1 - 1][col1 - 1];

	}

	/**
	 * This is very simple but not accepted as depending on no of queries , the
	 * method will get called multiple time
	 * 
	 */
	public int sumRegionInefficient(int row1, int col1, int row2, int col2) {
		int sum = 0;

		for (int i = row1; i <= row2; i++) {
			for (int j = col1; j <= col2; j++) {
				sum += dp[i][j];

			}

		}
		return sum;
	}
}
