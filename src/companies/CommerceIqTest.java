package companies;

import java.util.LinkedList;
import java.util.Queue;

public class CommerceIqTest {
	int count = 0;
	
	public static void main(String[] args) {
		char a[][] = {

				{ '1', '1', '1' }, { '1', '1', '1' }, { '1', '1', '2' } };
		System.out.println(new CommerceIqTest().countBadMangoes(a));

	}

	/**
	 * 2: bad 1: good 0: empty
	 */
	public int countBadMangoes(char a[][]) {
		int rows = a.length - 1;
		int cols = a[0].length - 1;
		if (rows == 0)
			return 0;
		
		
		boolean visited[] = new boolean[rows+1];

		for (int i = 0; i <= rows; i++) {
			for (int j = 0; j <=cols; j++) {
				if (a[i][j] == '2') {
					bfs(i, j, a, visited, count);
					//
				}

			}

		}
		return count;

	}

	private void bfs(int i, int j, char[][] a, boolean visited[], int count) {
		// boundary check
		//System.out.println(i+" =----"+j);
		if (i < 0 || j < 0  || i > a.length-1 || j >a[0].length-1 || visited[i] || a[i][j] == '0') {
			return;
		}
		visited[i] = true;
		count++;
		System.out.println("---->"+count);
		a[i][j] = '2';
		bfs(i + 1, j, a, visited, count); // up
		bfs(i - 1, j, a, visited, count); // down
		bfs(i, j + 1, a, visited, count); // right
		bfs(i, j - 1, a, visited, count); // left
		visited[i] = false;

	}

}
