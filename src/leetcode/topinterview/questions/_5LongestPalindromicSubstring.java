package leetcode.topinterview.questions;
/**
 * https://www.youtube.com/watch?v=obBdxeCx_Qs
 * @author sramveer
 *
 */

public class _5LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrominStrBrootForce("cbbd"));
		
		System.out.println(maxLengthPalindromDP("babad"));

		System.out.println("kkkkkkkk ....." + IsPalindrom("ab"));
	}

	/**
	 * https://www.youtube.com/watch?v=UflHuQj6MVA
	 * 
	 *           We define P(i,j)P(i,j) as following:

p(i,j) = true if si...sj is palindrom 
else false
 

Therefore,
	P(i, j) = ( P(i+1, j-1) \text{ and } S_i == S_j )P(i,j)=(P(i+1,j−1) and Si==Sj)

			The base cases are:

			P(i, i) = trueP(i,i)=true

			P(i, i+1) = ( S_i == S_{i+1} )P(i,i+1)=(Si==Si+1)
	 * 
	 */
	private static String maxLengthPalindromDP(String input) {
		int n = input.length();
		int palindromBeginsAt = 0;
		int maxLength = 1;
		boolean pal[][] = new boolean[n][n];
		/**
		 * for single letter palindrom , mark all diagonal strings as true
		 * a single char will always be palindrom
		 */
		for (int i = 0; i < n; i++) {
			pal[i][i] = true;
		}
		/**
		 * for 2 letters , if first and last char are same then they are palindrom
		 */
		for (int i = 0; i < n - 1; i++) {
			if (input.charAt(i) == input.charAt(i + 1)) {
				pal[i][i + 1] = true;
				palindromBeginsAt = i;
				maxLength = 2;
			}
		}
		/**
		 * 
		 * 
		 * for 3 length string do two things 
		 * 1. find if first and last char are same 
		 * 
		 * 2.find if p[i+1][j-1] is palindrom
		 */

		for (int curr_length = 3; curr_length <= n; curr_length++) {
			for (int i = 0; i < n - curr_length + 1; i++) {
				int j = i + curr_length - 1;

				if (input.charAt(i) == input.charAt(j) && pal[i + 1][j - 1]) {
					pal[i][j] = true;

					palindromBeginsAt = i;
					maxLength = curr_length;
				}

			}
		}
		return input.substring(palindromBeginsAt, maxLength + palindromBeginsAt);
	}

	private static String longestPalindrominStrBrootForce(String input) {
		String localMax = "";
		String max = "";
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j < input.length(); j++) {
				String s = input.substring(i, j);
				if (IsPalindrom(s)) {
					localMax = s;
					if (localMax.length() > max.length()) {
						max = localMax;

					}
				}
			}
		}
		return max;
	}

	private static boolean IsPalindrom(String input) {
		int i = 0, j = input.length() - 1;
		while (i < j) {
			if (input.charAt(i) == input.charAt(j)) {
				i++;
				j--;

			} else {
				return false;
			}
		}
		return true;

	}
}
