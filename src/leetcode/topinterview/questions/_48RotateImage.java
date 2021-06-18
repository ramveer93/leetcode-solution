package leetcode.topinterview.questions;

//https://www.youtube.com/watch?v=VDw9y6nX_ss  transpose of a matrix a[j][i] = t[i][j]

//https://www.youtube.com/watch?v=SA867FvqHrM
public class _48RotateImage {

	/**
	 * idea is 
	 * 1. first do the transpose of the matrix 
	 *
	 * matrix : a[j][i] = a[i][j];
	 *  
	 * 2. then swap a[i] with a[a.length-1]
	 * 
	 * 
	 * 
	 * e.g:
	 * 
	 * [1,2,3] 
	 * [4,5,6] 
	 * [7,8,9]
	 * 
	 * step 1: do the transpose of the matrix
	 * 
	 * [1,4,7] 
	 * [2,5,8] 
	 * [3,6,9]
	 * 
	 * step 3. swap first column value to last column value in all the rows 
	 * [7,4,1]
	 * [8,5,2] 
	 * [9,6,3]
	 * 
	 * 
	 * 
	 * 
	 * https://www.youtube.com/watch?v=SA867FvqHrM
	 * 
	 * 
	 */
	public void rotateImg(int a[][]) {
		int rows = a.length;
		int col = a[0].length;
		// do the transpose of the matrix, doing j = i , because if we dont do that then this wonts be the transpose , 
		// it will just print the elements as it is 
		for (int i = 0; i < rows; i++) {
			for (int j = i; j < col; j++) {
				int temp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = temp;

			}

		}
		
		// now swap first and last columns of every row
		for(int i=0;i<rows;i++)
		{
			int low = 0;
			int high = col-1;
			while(low<high)
			{
				int temp = a[i][high]; // i will be fixed here because we want to iterate to every row 
				a[i][high] = a[i][low];
				a[i][low] = temp;
				low++;
				high--;
			}
			
		}
		

	}

	/**
	 * 
	 * 
	 * ex. [1,2,3] [4,5,6] [7,8,9]
	 * 
	 * transpose:
	 * 
	 * [1,4,7] [2,5,8] [3,6,9]
	 * 
	 * basically a[i][j] is becoming a[j][i] so swapping a[i][j] to a[j][i] will do
	 * the transpose int temp = a[i][j]; a[i][j] = a[j][i]; a[j][i] = temp;
	 * 
	 * 
	 * 
	 * 
	 * @param a
	 * @return
	 */
	public int[][] transpose(int a[][]) {
		int row = a.length;
		int col = a[0].length;
		int temp[][] = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				temp[j][i] = a[i][j];

			}
		}
		return temp;

	}

}
