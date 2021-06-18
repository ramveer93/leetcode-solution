package leetcode.topinterview.questions;

import java.util.Arrays;

public class _324WiggleSortII {

	public static void main(String[] args) {

		int a[] = {1, 5, 1, 1, 6, 4};
		new _324WiggleSortII().wiggleSort(a);
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
			
		}
	}

	public void wiggleSort(int a[]) {
		int copy[] = Arrays.copyOf(a, a.length);
		Arrays.sort(copy);
		int n = copy.length;
		int left = (n + 1) / 2 - 1; // median index
		int right = n - 1; // largest value

		for (int i = 0; i < a.length; i++) {
			// copy large values on odd indexes
			if (i % 2 == 1) { // odd index
				a[i] = copy[right];
				right--;
			} else {// copy values decremeting from median on even indexes
				a[i] = copy[left];
				left--;
			}

		}

	}
}
