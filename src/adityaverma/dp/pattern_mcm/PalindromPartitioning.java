package adityaverma.dp.pattern_mcm;

public class PalindromPartitioning {

	private static int[][] t;

	public static void main(String[] args) {
		String x = "geek";
		t = new int[x.length() + 1][x.length() + 1];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j] = -1;

			}

		}
		System.out.println(new PalindromPartitioning().recursion(x, 0, x.length() - 1));
		System.out.println(new PalindromPartitioning().memoization(x, 0, x.length() - 1));
	}

	/**
	 * Find min no of partitions of x such that 
	 * all partitions are palindrom
	 */
	public int recursion(String s, int i, int j) {
		if (i >= j)
			return 0;
		if (isPal(s, i, j))
			return 0;
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int tempRes = recursion(s, i, k) + recursion(s, k + 1, j) + 1;
			if (tempRes < min)
				min = tempRes;

		}
		return min;

	}

	// dalad
	private boolean isPal(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else
				return false;

		}
		return true;
	}

	public int memoization(String x, int i, int j) {
		if (i >= j)
			return 0;
		if (isPal(x, i, j))
			return 0;
		if(t[i][j]!=-1)return t[i][j];
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int temp = memoization(x, i, k) + memoization(x, k + 1, j) + 1;
			if (temp < min)
				min = temp;

		}

		return t[i][j] = min;
	}

}
