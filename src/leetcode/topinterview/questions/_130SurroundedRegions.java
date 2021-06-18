package leetcode.topinterview.questions;

public class _130SurroundedRegions {

	public static void main(String[] args) {
		//char a[][] = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' } };
		char a[][]  = {{'O','O'},{'O','O'}};
		new _130SurroundedRegions().solve(a);
		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");

			}
			System.out.println();
		}

	}

	/**
	 * https://www.youtube.com/watch?v=PIwYN5h4LwU
	 * 
	 * Algo: 1. visit all four boundaries and find if there is any O or any O
	 * connected regions , then mark that with # 2. now iterate whole matrix and see
	 * if there is any O -> convert it to X # -> O
	 */
	public void solve(char a[][]) {
		if (a.length == 0) {
			return;

		}
		// first check for first and last rows
		for (int i = 0; i < a[0].length; i++) {
			if (a[0][i] == 'O') // first row
			{
				dfs(a, 0, i);

			}
			if (a[a.length - 1][i] == 'O') // last row
			{
				dfs(a, a.length - 1, i);
			}

		}
		// first column and last columns
		for (int i = 0; i < a.length; i++) {
			if (a[i][0] == 'O') // first column
			{
				dfs(a, i, 0);

			}
			if (a[i][a[0].length - 1] == 'O') {
				dfs(a, i, a[0].length - 1);

			}
		}

		// NOW WE HAVE TO MARK ALL THE # TO O AND ALL O TO X
		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < a.length; j++) {
				if (a[i][j] == '#') {
					a[i][j] = 'O';

				}
				else if (a[i][j] == 'O') {
					a[i][j] = 'X';

				}

			}
		}

	}

	public void dfs(char a[][], int i, int j) {
		// boundary check
		if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || a[i][j] == 'X') {
			return;
		}
		a[i][j] = '#';
		dfs(a, i + 1, j); // up
		dfs(a, i - 1, j); // down
		dfs(a, i, j + 1); // right
		dfs(a, i, j - 1); // left

	}
}
