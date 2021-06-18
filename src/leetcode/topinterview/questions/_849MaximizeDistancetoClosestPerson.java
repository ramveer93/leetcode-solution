package leetcode.topinterview.questions;

public class _849MaximizeDistancetoClosestPerson {

	public static void main(String[] args) {

	}

	/**
	 * 
	 * https://www.youtube.com/watch?v=JtpGVqbiegQ
	 * 
	 * 2 cases: 1. if he is sitting in middle: k+1/2 , k is no of consequtive 0s 2.
	 * when he is sitting on edges, both left and right: idx1 and n-idx2-1 finally
	 * take the max of all three
	 */
	public int maxDistToClosest(int a[]) {
		int result = 0;
		int empty = 0;// count of consequtive 0s
		int idx1 = -1;
		int idx2 = -1;
		int n = a.length;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == 1) {
				empty = 0;
				if (idx1 == -1)
					idx1 = i;
				idx2 = i;
			} else {
				// sitting in middle
				empty++;
				result = Math.max(result, (empty + 1) / 2);
			}

		}

		return Math.max(result, Math.max(idx1, n - 1 - idx2));

	}
}
