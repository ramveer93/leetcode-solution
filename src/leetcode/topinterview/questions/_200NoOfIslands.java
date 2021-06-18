package leetcode.topinterview.questions;

public class _200NoOfIslands {
	public static void main(String[] args) {
		char a[][] = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(new _200NoOfIslands().islandCount(a));

	}
/**
 * https://www.youtube.com/watch?v=__98uL6wst8
 */
	public int islandCount(char a[][]) {
		int r = a.length;
		int c = a[0].length;
		if (r == 0)
			return 0;
		int count = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (a[i][j] == '1') {
					dfs(a, i, j, r, c);
					count++;
				}

			}

		}
		return count;

	}

	public void dfs(char a[][], int i, int j, int r, int c) {
		// boundary check
		if (i < 0 || i >= r || j < 0 || j >= c || a[i][j] != '1')
			return;
		a[i][j] = '2';
		dfs(a, i + 1, j, r, c);
		dfs(a, i - 1, j, r, c);
		dfs(a, i, j + 1, r, c);
		dfs(a, i, j - 1, r, c);

	}

}
