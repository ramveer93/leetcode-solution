package leetcode.topinterview.questions;

public class _238ProductOfArrayExceptSelf {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4 };
		// int p[] = new _238ProductOfArrayExceptSelf().productBruteForce(a);
		int p[] = new _238ProductOfArrayExceptSelf().productEfficient(a);

		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);

		}
	}

	public int[] productBruteForce(int a[]) {
		int res[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int prod = 1;
			for (int j = 0; j < a.length; j++) {

				if (i != j) {
					prod = prod * a[j];
				}

			}
			res[i] = prod;

		}
		return res;

	}

	/**
	 * calculate product of all elements in array = pr now for every element in
	 * array , keep dividing the product with the number itself to get product
	 * except it self
	 */
	public int[] productEfficientByUsingDivision(int a[]) {
		int prod = 1;
		for (int i = 0; i < a.length; i++) {
			prod *= a[i];
		}
		int res[] = new int[a.length];
		for (int j = 0; j < a.length; j++) {
			res[j] = prod / a[j];
		}
		return res;
	}

	/**
	 * Idea is to maintain 2 arrays: 
	 * L[a.length], R[a.length] to fill 
	 * L[i] = L[i-1]*a[i-1];, L[0] = 1; , L-> product of all elements to left of i R->
	 * product of all elements to the right of i R[i] = R[i+1]*a[i+1], R[a.length-1]
	 * = 1:-> in case of R we have to do i+1, because we want to see the last value
	 * which will come only i+1
	 * 
	 * Result will be L[i]*R[i]
	 * 
	 * Time: O(n) Space: O(2n) = O(n)
	 * 
	 */
	public int[] productEfficient(int a[]) {
		int L[] = new int[a.length];
		int R[] = new int[a.length];
		// fill the L
		L[0] = 1;
		for (int i = 1; i < a.length; i++) {
			L[i] = L[i - 1] * a[i - 1];
		}

		// fill the L
		R[a.length - 1] = 1;
		for (int i = a.length - 2; i >= 0; i--) {
			R[i] = R[i + 1] * a[i + 1];
		}

		int res[] = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			res[i] = L[i] * R[i];
		}

		return res;

	}

}
