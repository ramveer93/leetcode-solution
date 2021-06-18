package leetcode.topinterview.questions;

public class _79WordSearch {

	boolean[][] visited;   // so that we are not visiting the same char again for e.g ABCCFSADEESECB in given out will return 
//	false as we are visiting c and b agaiin 
	
	public static void main(String[] args) {
		char [][] a = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		System.out.println(new _79WordSearch().exist(a, "ABCCFSADEESECB"));
	}

	/**
	 * https://www.youtube.com/watch?v=m9TrOL1ETxI
	 * 
	 * 
	 * 
	 */
	public boolean exist(char[][] board, String word) {
		int rows = board.length;
		int cols = board[0].length;

		visited = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == word.charAt(0) && search(i, i, 0, board, word)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean search(int i, int j, int count, char[][] board, String word) {
		if (count == word.length()) {
			return true;

		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(count)
				|| visited[i][j]) {
			//if we remove || visited[i][j] then ABCCFSADEESECB word will also gives true , else false
			return false;

		}
		visited[i][j] = true;
		if ( search(i + 1, j, count + 1, board, word) || 
			 search(i - 1, j, count + 1, board, word) || 
			 search(i, j + 1, count + 1, board, word) || 
			 search(i, j - 1, count + 1, board, word)

		) {
			visited[i][j] = false;
			return true;
		}
		visited[i][j] = false;

		return false;

	}

}
