package leetcode.topinterview.questions;

/**
 * https://www.youtube.com/watch?v=l3hda49XcDE
 * 
 * @author sramveer
 *
 */

public class _10RegularExpressionMatching {
	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a*"));
		boolean tt[][] = new boolean[3][4];
		System.out.println("tt length: " + tt.length);
		System.out.println("tt[0] length.." + tt[0].length);
		System.out.println(matchRegex("aa".toCharArray(), "a*".toCharArray()));
	}

	/**
	 * T[i][j] -> i is the index in text and j is the index in pattern
	 * 
	 * 
	 * case 1: T[i][j] = T[i-1][j-1]. IF text[i] == p[j] || p[j] = '.'
	 * 
	 * eg: t: ab and p: ab => or t: ab and p: a. so both are match hence t[i][j] =
	 * true
	 * 
	 * 
	 * Case 2: T[i][j] = T[i][j-2] (only when T[i][j] is true) when p[j] = '*' ,
	 * because we will move two step back, 0 occurances of char before *
	 * 
	 * Case 2.1: T[i][j] = T[i][j] || T[i-1][j] when p[j-2] = '.' OR p[j-2] ==
	 * t[i-1]
	 * 
	 * 
	 */
	public static boolean matchRegex(char[] text, char[] pattern) {
		boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

		T[0][0] = true;
		// Deals with patterns like a* or a*b* or a*b*c*
		for (int i = 1; i < T[0].length; i++) {
			if (pattern[i - 1] == '*') {
				T[0][i] = T[0][i - 2];
			}
		}

		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[0].length; j++) {
				if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
					T[i][j] = T[i - 1][j - 1];
				} else if (pattern[j - 1] == '*') {
					T[i][j] = T[i][j - 2]; // e.g: p: xa* and t: x after removing 2 char from p both are same so this
											// will be true
					if (pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1]) {
						T[i][j] = T[i][j] | T[i - 1][j];
					}
				} else {
					T[i][j] = false;
				}
			}
		}
		return T[text.length][pattern.length];
	}

	public static boolean isMatch(String s, String ptr) {
		int strLength = s.length();
		int patternLength = ptr.length();

		char text[] = s.toCharArray();
		char p[] = ptr.toCharArray();

		boolean t[][] = new boolean[strLength + 1][patternLength + 1];
		t[0][0] = true;

		// handle the case with first row
		for (int i = 1; i < patternLength + 1; i++) {
			if (p[i - 1] == '*') {
				t[0][i] = t[0][i - 2];

			}
		}

		for (int i = 1; i < strLength + 1; i++) {
			for (int j = 1; j < patternLength + 1; j++) {
				if (p[j - 1] == '.' || p[j - 1] == text[i - 1]) {
					t[i][j] = t[i - 1][j - 1];
				} else if (p[j - 1] == '*') {
					t[i][j] = t[i][j - 2];
					if (p[j - 2] == '.' || p[j - 2] == text[i - 1]) {
						t[i][j] = t[i][j] | t[i - 1][j];
					}
				} else {
					t[i][j] = false;
				}
			}
		}
		return t[strLength][patternLength];

	}

}
