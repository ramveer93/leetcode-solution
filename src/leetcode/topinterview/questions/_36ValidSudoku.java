package leetcode.topinterview.questions;

import java.util.HashSet;
import java.util.Set;

public class _36ValidSudoku {

	/**
	 * idea is to insert a signature in the set to cover all three cases
	 * 
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku(char[][] board) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (c != '.') {
					if (!set.add(c + " row " + i) || !set.add(c + " column " + j)
							|| !set.add(c + " grid " + i / 3 + " - " + j / 3)) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
