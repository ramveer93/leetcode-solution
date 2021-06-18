package leetcode.topinterview.questions;

public class _125ValidPalindrome {

	public static void main(String[] args) {
     System.out.println(new _125ValidPalindrome().validPalindrome("race a car"));
	}

	public boolean validPalindrome(String s) {
		s = s.toLowerCase();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (isChar(s.charAt(i))) {
				sb.append(s.charAt(i));
			}
		}
		s = sb.toString();
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {

			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isChar(char c) {
		return c >= 'a' && c <= 'z' || c>='0' && c<='9';

	}

}
