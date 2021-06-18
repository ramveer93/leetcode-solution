package leetcode.topinterview.questions;

public class _240SearchInA2DMatrix {
	public static void main(String[] args) {
		int a[][] = {

				{ 1, 4, 7, 11, 15 },
				{ 2, 5, 8, 12, 19 }, 
				{ 3, 6, 9, 16, 22 }, 
				{ 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 }

		};
		System.out.println(new _240SearchInA2DMatrix().search(a, 16));
	}

	/**
	 * 
	 *start from first corner
	 */
	public boolean search(int a[][], int k) {
		int rows = a.length;
		 if(rows == 0) return false;
		int cols = a[0].length;

		int i = 0;
		int j = cols - 1;

		while (i < rows && j >= 0) {
			if (a[i][j] == k)
				return true;
			else if (a[i][j] > k) {
				j--;
			} else if (a[i][j] < k) {
				i++;
			}

		}
		return false;

	}
}
