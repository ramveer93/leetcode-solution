package leetcode.topinterview.questions;

public class _44WildCardMatching {
	public static void main(String[] args) {
		System.out.println(isMatch("abccncncnmcnmcmcnmcmcnmcnmcmcnmnm", "ab***************"));
	}

	/**
	 * 
	 * https://www.youtube.com/watch?v=3ZDZ-N0EPV0
	 * 
	 * idea is two conditions
	 *  
	 * 1. if(s[i-1] == p[j-1] || p[j-1] == '?') 
	 * then t[i][j] = t[i-1][j-1]; 
	 * 
	 * 2. if(p[j-1] == '*') then t[i][j] = t[i-1][j] || t[i][j-1];
	 * 
	   3.else false
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		boolean t[][] = new boolean[s.length() + 1][p.length() + 1];
		t[0][0] = true; // empty string and empty pattern will always match
		for (int i = 0; i < p.length() && p.charAt(i++) == '*';) // every column value will be true if it has * from 0
																	// index like *, **
		{
			t[0][i] = true;

		}
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
					t[i][j] = t[i - 1][j - 1];

				} else if (p.charAt(j - 1) == '*') {
					t[i][j] = t[i][j - 1] || t[i - 1][j];

				} else {
					t[i][j] = false;
				}

			}

		}
		return t[s.length()][p.length()];

	}

}
