package leetcode.topinterview.questions;

public class _31NextPermutation {

	public static void main(String[] args) {

		
		int a[] = {2,3,1};
		new _31NextPermutation().nextPerm(a);
		for(int i = 0;i<a.length;i++)System.out.print(a[i]);
	}

	/**
	 * https://www.youtube.com/watch?v=dMQcTJkypCg
	 * 
	 * two cases:
	 * 
	 * 1. eg. [3 2 1] if all the elements in array are descending then just reverse
	 * the array
	 * 
	 * ------------
	 * 
	 * 0 1 2 3 4 5 6 
	 * [6 2 1 5 4 3 0] we have to start from end and find the
	 * partition element where descending order is breaking here after index 3 the
	 * order is breaking, so we will swap the 2nd element with the next bigger
	 * number 2nd element is 1 , so find next bigger element than 1 in right array,
	 * which is 3 , swap 1 with 3
	 * 
	 * 0 1 2 3 4 5 6 
	 * [6 2 3 5 4 1 0]
	 * 
	 * now reverse the right part
	 * 
	 * 0 1 2 3 4 5 6 
	 * [6 2 3 0 1 4 5] this is the answer
	 * 
	 * 
	 * 
	 */
	public void nextPerm(int a[]) {
		if(a.length == 0)return;
		// case 1
		int k = a.length - 2;

		while (k >= 0 && a[k] >= a[k + 1]) {
			k--;
		}
		if (k == -1) {
			reverseArrays(0, a.length - 1, a);
			return;
		}
		// -----------2nd case----------------
		// k is partition element here , now find element greater element than a[k] in
		// right part
		for (int i = a.length - 1; i > k; i--) {
			if (a[i] > a[k]) {
				int temp = a[i];
				a[i] = a[k];
				a[k] = temp;
				break;

			}

		}
		// last step to reverse the k+1 to end array
		reverseArrays(k + 1, a.length - 1, a);

	}

	public void reverseArrays(int start, int end, int a[]) {
		while (start < end) {
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}

	}
}
