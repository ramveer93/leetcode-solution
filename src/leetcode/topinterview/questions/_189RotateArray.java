package leetcode.topinterview.questions;

public class _189RotateArray {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		new _189RotateArray().rotateArray(a, 3);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");

		}

	}

	/**
	 * 1. first rotate whole array : 7,6,5,4,3,2,1 2. rotate first k numbers(k =3):
	 * 5,6,7, 4,3,2,1 3. Rotate last n-k numbers(n=7, k =3 so n-k = 4):
	 * 5,6,7,1,2,3,4
	 */
	public void rotateArray(int a[], int k) 
	{
		k = k%a.length;
		reverse(0,a.length-1,a);
		reverse(0,k-1,a);
		reverse(k,a.length-1,a);
		

	}

	private void reverse(int start, int end, int a[]) {
		while (start < end) {
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;

		}

	}

}
