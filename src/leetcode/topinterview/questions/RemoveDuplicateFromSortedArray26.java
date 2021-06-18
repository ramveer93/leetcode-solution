package leetcode.topinterview.questions;

public class RemoveDuplicateFromSortedArray26 {
	public static void main(String[] args) {

		int a[] = {1,5,10,2,2, 3};
		System.out.println(removeDupliicates(a));
	}

	/**
	 * 
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/discuss/11769/5-lines-Java-solution
	 * 
	 * we are not removing duplicates we just have to shift the non duplicates
	 * 
	 * @param a
	 * @return
	 */
	public static int removeDupliicates(int a[]) {
		int count = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i] != a[i - 1]) {
				a[count++] = a[i];
				System.out.println(a[i]);

			}

		}
		
		return count;

	}

}
