package leetcode.topinterview.questions;

public class _647PalindromicSubstrings {

	public static void main(String[] args) {

		System.out.println(new _647PalindromicSubstrings().countSubstrings("aaa"));
	}

	/**
	 * https://www.youtube.com/watch?v=BShYX4aq22I This is same
	 * _5LongestPalindromicSubstring , we just have to count whenever there is a
	 * palindrom sub string
	 * 
	 * 
	 * 
	 * three rules:
	 * 
	 * 1. all single chars will be palindrom: so s[i][i] = true 2. all 2 length
	 * strings will be palindrom if first and last char is same 3. all 3 length str
	 * will be palindrom if first and last char same and remaining string is
	 * palindrom
	 * 
	 * 
	 */
	public int countSubstrings(String s) {
		int count = 0;
		char a[] = s.toCharArray();
		int n = a.length;
		boolean dp[][] = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
			count++;
		}
		// length 2
		for (int i = 0; i < n - 1; i++) {
			if (a[i] == a[i + 1]) {
				dp[i][i + 1] = true;
				count++;

			}

		}

		// length 3

		for (int currLength = 3; currLength <= n; currLength++) {
			for (int i = 0; i < n - currLength + 1; i++) {
				int j = i + currLength - 1;
				if (a[i] == a[j] && dp[i + 1][j - 1]) {
					dp[i][j] = true;
					count++;

				}

			}

		}

		return count;

	}
}
