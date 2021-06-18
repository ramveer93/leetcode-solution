package leetcode.topinterview.questions;

public class _680ValidPalindromII {

	public static void main(String[] args) {

		System.out.println(new _680ValidPalindromII().validPaliindrom("abbbcba"));
	}

	/**
	 * Given a non-empty string s, you may delete at most one character. Judge
	 * whether you can make it a palindrome.
	 * 
	 * Input: "abca" Output: True
	 * 
	 * 
	 * 
	 * https://www.youtube.com/watch?v=wTaJp8_bSLQ&list=PLzffTJx5aHaRY4_GOv8X-3pSeN2Zv2VYv&index=2
	 * 
	 * 
	 * 
	 *
	 */
	public boolean validPaliindrom(String s) {

		int count1 = 0, count2 = 0;
		int low = 0;
		int high = s.length() - 1;
		while (low < high) {
			if (s.charAt(low) == s.charAt(high)) {
				low++;
				high--;
			} else {
				low++;
				count1++;
			}
		}
		low = 0;
		high = s.length() - 1;
		while (low < high) {
			if (s.charAt(low) == s.charAt(high)) {
				low++;
				high--;
			} else {
				high--;
				count2++;
			}

		}

		if (count1<=1 || count2<=1)
			return true;
		
		return false;

	}
}
