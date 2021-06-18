package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _73SetMatrixZeroes {

	public static void main(String[] args) {
		//int a[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		int a[][] = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		new _73SetMatrixZeroes().markRowsColsAsZero(a);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");

			}
			System.out.println();

		}
	}

	public void markRowsColsAsZero(int a[][]) {
		int rows = a.length;
		int cols = a[0].length;
		List<Integer> temp = new ArrayList<>();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (a[i][j] == 0) {
					temp.add(i);
					temp.add(j);
				}
			}
		}
		setZero(temp, rows, cols, a);

	}

	public void setZero(List<Integer> tempList, int rows, int cols, int a[][]) {

		for (int p = 0; p < tempList.size() - 1; p = p + 2) {
			int i = tempList.get(p);
			int j = tempList.get(p + 1);

			Arrays.fill(a[i], 0);
			
			
//			// mark ith rows 0
//			for (int k = 0; k < cols; k++) {
//				a[i][k] = 0;
//			}
			// mark jth col 0
			for (int m = 0; m < rows; m++) {
				a[m][j] = 0;

			}
		}

	}

}
