package leetcode.topinterview.questions;

public class _665NonDecreasingArray {

	public static void main(String[] args) {

		int a[] = { -1, 4, 2, 3 };
		System.out.println(new _665NonDecreasingArray().checkPossibility(a));
	}

	/**
	 * check if given array can be made non decreasing by modifying one element
	 * https://www.youtube.com/watch?v=3UgvNI02ai4
	 * 
	 * 
	 * eg:
	 * 
	 * [5,8,4,10] => [5,8,8,10] : -> if(a[i-1]>a[i+1]) then modify the i+1
	 * [-1,4,2,3] => [-1,2,2,3] : -> if(a[i-1]<a[i+1]) then modify the ith element
	 * 
	 */
	public boolean checkPossibility(int a[]) {
		int count = 0;

		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				count++;
				if (count > 1) {
					return false;

				}

				if (i > 0 && a[i - 1] > a[i + 1]) {
					a[i + 1] = a[i];

				} else { // a[i-1]<a[i+1] : modify the ith element
					a[i] = a[i + 1];

				}

			}

		}
		return true;

	}
}
