package leetcode.topinterview.questions;

public class _63UniquePathsII {

	/**
	 * https://www.youtube.com/watch?v=favJnfIiPSQ
	 * 
	 * 
	 * if a[i][j] == 1 then this is obstacle so we cant use this path and will put 0
	 * there
	 * 
	 * @return
	 */
	public int uniquePathsWithObstacle(int a[][]) {
		int row = a.length;
		int col = a[0].length;
		if (row == 0)
			return 0;
		if (a[0][0] == 1)
			return 0;// if first element is obstacle then we cant go anywhere so 0 paths

		int dp[][] = new int[row][col];

		// first col
		for (int i = 0; i < col; i++) {
			if (a[0][i] == 0) {
				dp[0][i] = 1;

			} else {
				break;
			}

		}

		for (int i = 0; i < row; i++) {
			if (a[i][0] == 0) {
				dp[i][0] = 1;
			} else {
				break;
			}

		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (a[i][j] == 1) {
					dp[i][j] = 0;

				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}

			}

		}
		return dp[row][col];
	}
}
