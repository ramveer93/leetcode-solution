package leetcode.topinterview.questions;

public class _266PalindromePermutation {

	public static void main(String[] args) {
		System.out.println(canPermutePermitation("abvba"));
	}

	/**
	 * https://www.youtube.com/watch?v=Pp5hdsNdqOU
	 * 
	 * 
	 * given a string, we have to find if its permutation can be a palindrom or not
	 * 
	 * 
	 * Idea is to store all the counts of the chars to be a palindrom , the
	 * frequency of char should be multiple of 2 to be a palindrom
	 * 
	 */
	public static boolean canPermutePermitation(String s) {
		int[] charCount = new int[126];
		for (int i = 0; i < s.length(); i++) {
			charCount[s.charAt(i)]++; // here we are not doing charCount[s.charAt(i)-'a'] as we need the index to be
										// 126 not 26

		}

		int count = 0;

		for (int i = 0; i < 126; i++) {
			count += charCount[i] % 2;

		}

		return count <= 1;

	}
}
