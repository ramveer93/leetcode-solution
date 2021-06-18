package leetcode.topinterview.questions;

public class _75SortColors {
	public static void main(String[] args) {
		int a[] = { 0, 1, 2, 0, 2, 2, 1, 0, 0, 0, 1 };
		new _75SortColors().sortColorsEfficient(a);
		// new _75SortColors().sortColors(a,false);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);

		}

	}

	public void sortColorsEfficient(int a[]) {
		if(a.length ==0) return;
		int start = 0;
		int end = a.length - 1;
		int index = 0;
		while (start < end && index <= end) {
			if (a[index] == 0) // that means there is a 0 in middle so swap that with start as 0s we need in
								// left side and start
								// start will always behind the index , also start will always point to elements
								// where 0 should come
			{
				int temp = a[index];
				a[index] = a[start];
				a[start] = temp;
				start++;
				index++;

			} else if (a[index] == 2) // so 2 comes in middle , we have to swap a[index]with a[ends] as we want all 2s
										// to go to right side
			{
				int temp = a[index];
				a[index] = a[end];
				a[end] = temp;
				end--;
				//index++;
			} else {
				index++; // it will come here only when we have 1s, so no need to swap
			}

		}

	}

	/**
	 * only for two types of elements in array
	 * 
	 * @param a
	 * @param sortForZero
	 */
	public void sortColors(int a[], boolean sortForZero) {
		int left = 0;
		int right = a.length - 1;
		while (left <= right) {
			if (a[left] == 0) {
				left++;

			}
			if (a[right] == 1) {
				right--;
			}
			if (a[left] != 0 && a[right] != 1) {
				int temp = a[left];
				a[left] = a[right];
				a[right] = temp;
				left++;
				right--;

			}

		}

	}
}
