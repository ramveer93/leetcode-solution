
package leetcode.topinterview.questions;

public class _340LongestSubstringwithAtMostKDistinctCharacters {

	public static void main(String[] args) {

		System.out.println(
				new _340LongestSubstringwithAtMostKDistinctCharacters().longstSubstringWithKDistinctChars("eceba", 2));
	}

	public int longstSubstringWithKDistinctChars(String s, int k) {

		// base case
		if (s == null || s.length() == 0)
			return 0;
		int charCount[] = new int[256];
		int distinct = 0;
		int i = 0;
		String res = "";
		int max = Integer.MIN_VALUE;
		for (int j = 0; j < s.length(); j++) {
			if (charCount[s.charAt(j)] == 0) {
				distinct++;
			}
			charCount[s.charAt(j)]++;
			while (distinct > k) {
				charCount[s.charAt(i)]--;
				if (charCount[s.charAt(i)] == 0)
					distinct--;
				i++;
			}
			if (j - i + 1 > max) {
				max = j - i + 1;
				res = s.substring(i, j + 1);
			}

		}

		System.out.println("----------result string is : " + res);
		return max;

	}
}
