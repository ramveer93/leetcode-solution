package leetcode.topinterview.questions;

public class _283MoveZeros {

	public static void main(String[] args) {

		int a[] = { 0, 3, 0, 0, 12 };
		new _283MoveZeros().moveZeros(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);

		}
	}

	/**
	 * https://www.youtube.com/watch?v=0rPuILjoVsg&feature=emb_title
	 * 
	 * we have to maintain the order of ements also
	 * 
	 * move k every time but swap only when k not pointing to 0 move i only when we
	 * are swapping
	 * 
	 * @param a
	 */
	public void moveZeros(int a[]) {
		int i = 0;

		for (int k = 0; k < a.length; k++) {
			if (a[k] != 0) {
				int temp = a[i];
				a[i] = a[k];
				a[k] = temp;
				i++;
			}

		}

	}
}
