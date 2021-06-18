package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

public class _212WordSeearch2 {

	boolean[][] visited;

	public static void main(String[] args) 
	{
		char board[][] = {
				{'a','a'},
				//{'e','t','a','e'},
			//	{'i','h','k','r'},
				//{'i','f','l','v'}
		};
		String [] words = {"aaa"};
     System.out.println(new _212WordSeearch2().findWords(board, words).toString());
	}

	/**
	 * just extension of https://leetcode.com/problems/word-search/ for every word
	 * search if that exists in board or not , if yes put it inot res
	 * 
	 * 
	 * https://leetcode.com/problems/word-search-ii/discuss/857148/Standard-Java-DFS-without-a-Trie.-98-space.-22-Speed.-Useful-comments.
	 */
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();
		
		visited = new boolean[board.length][board[0].length];
		for (String word : words) {
			boolean found = false;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == word.charAt(0) && search(i, j, 0, board, word)) {
						found = true;
						res.add(word);
						
						break;

					}
				}
				if (found)
					break;

			}

		}
		return res;

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
