package adityaverma.stack;

/**
 * Given a binary matrix, find the maximum size rectangle binary-sub-matrix with
 * all 1’s. Example:
 * 
 * Input : 0 1 1 0 
 *         1 1 1 1 
 *         1 1 1 1 
 *         1 1 0 0
 * 
 * https://www.youtube.com/watch?v=St0Jf_VmG_g&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=8
 *
 */
public class _8MaxAreaRectangleInBinaryMatrix {

	public static void main(String[] args) {
		int a[][] = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		System.out.println(new _8MaxAreaRectangleInBinaryMatrix().marInBinaryMatrix(a,a.length,a[0].length));
	}

	public int marInBinaryMatrix(int a[][], int r, int c) {
		int max = 0;
		int[] temp = new int[c];
		for (int i = 0; i < c; i++) {
			temp[i] = a[0][i];
		}
		max = new _7MaximumAreaHisogram().maxAreaHistogram(temp);
		for (int i = 1; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (a[i][j] == 1) {
					temp[j] = temp[j] + a[i][j];
				} else {
					temp[j] = 0;
				}
			}
			max = Math.max(max, new _7MaximumAreaHisogram().maxAreaHistogram(temp));
		}
		return max;

	}
}
