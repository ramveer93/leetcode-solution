package leetcode.topinterview.questions;

public class _152MaximumProductSubarray {

	public static void main(String[] args) {
		int a[] = { -2, 0, -1 };
		System.out.println(new _152MaximumProductSubarray().maxProduct(a));

	}

	/**
	 * https://www.youtube.com/watch?v=hJ_Uy2DzE08
	 */
	public int maxProduct(int a[]) {
		int maxEndinghere = a[0];
		int minEndinghere = a[0];
		int maxOverall = a[0];
		for (int i = 1; i < a.length; i++) {
			int temp = maxEndinghere;
			/**
			 * so we have to chose between 3 things, 1. a[i] if maxEndinghere is 0, 2.
			 * a[i]*maxEndingHere if a[i] and maxEndinghere both are +ive 3.
			 * a[i]*minEndingHre is a[i] is -ive and maxEndinghere is also -ive
			 * 
			 * same for minEndinghere
			 * 
			 */
			maxEndinghere = Math.max(a[i], Math.max(a[i] * maxEndinghere, a[i] * minEndinghere));
			minEndinghere = Math.min(a[i], Math.min(a[i] * minEndinghere, temp * a[i]));
			maxOverall = Math.max(maxOverall, maxEndinghere);

		}
		return maxOverall;

	}
}
