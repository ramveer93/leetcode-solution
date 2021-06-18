package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

public class _417PacificAtlanticWaterFlow {

	/**
	 * https://www.youtube.com/watch?v=VC9BYJvFeC8
	 */
	public List<List<Integer>> pacificAtlantic(int[][] matrix) {

		int row = matrix.length;
		List<List<Integer>> res = new ArrayList<>();
		if (row == 0)
			return res;
		int col = matrix[0].length;

		int[][] pac = new int[row][col];
		int[][] atl = new int[row][col];

		// first row pacific
		for (int i = 0; i < col; i++) {
			dfs(matrix, 0, i, pac, Integer.MIN_VALUE);

		}

		// first col pacific
		for (int i = 0; i < row; i++) {
			dfs(matrix, i, 0, pac, Integer.MIN_VALUE);

		}

		// last row atlantic
		for (int i = 0; i < col; i++) {
			dfs(matrix, row - 1, i, atl, Integer.MIN_VALUE);

		}

		// last col atlantic
		for (int i = 0; i < row; i++) {
			dfs(matrix, i, col - 1, atl, Integer.MIN_VALUE);
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (pac[i][j] == 1 && atl[i][j] == 1) {
					List<Integer> temp = new ArrayList<>();
					temp.add(i);
					temp.add(j);
					res.add(temp);

				}

			}

		}

		return res;

	}

	private void dfs(int[][] matrix, int i, int j, int[][] temp, int prev) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || temp[i][j] == 1 || prev > matrix[i][j]) {
			return;
		}

		temp[i][j] = 1;
		dfs(matrix, i + 1, j, temp, matrix[i][j]);
		dfs(matrix, i - 1, j, temp, matrix[i][j]);
		dfs(matrix, i, j + 1, temp, matrix[i][j]);
		dfs(matrix, i, j - 1, temp, matrix[i][j]);

	}
}
