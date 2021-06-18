package leetcode.topinterview.questions;

public class _329LongestIncreasingPathInMatrix {

	public static void main(String[] args) {

	}

	/**
	 * https://www.youtube.com/watch?v=-UeIgUqAFbM
	 */
	public int longestPath(int a[][]) {
		int rows = a.length;
		if (rows == 0)
			return 0;
		int cols = a[0].length;
		int max = 0;
		int dp[][] = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (dp[i][j] == 0) {
					dfs(a, i, j, Integer.MIN_VALUE, dp);
					max = Math.max(max, dp[i][j]);

				}

			}

		}
		return max;

	}

	public int dfs(int a[][], int i, int j, int pre, int[][] dp) {

		if (i < 0 || j < 0 || i > a.length - 1 || j > a[0].length - 1)
			return 0;
		else if (pre >= a[i][j])
			return 0;
		else if (dp[i][j] != 0)
			return dp[i][j];

		int path1 = dfs(a, i + 1, j, a[i][j], dp);
		int path2 = dfs(a, i - 1, j, a[i][j], dp);
		int path3 = dfs(a, i, j + 1, a[i][j], dp);
		int path4 = dfs(a, i, j - 1, a[i][j], dp);
		int max1 = Math.max(path1, path2);
		int max2 = Math.max(path3, path4);
		dp[i][j] = 1 + Math.max(max1, max2);
		return dp[i][j];

	}
}
