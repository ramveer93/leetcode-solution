package leetcode.topinterview.questions;

import java.util.Arrays;

public class _1160FindWordsThatCanBeFormedbyCharacters {

	public static void main(String[] args) {

	}

	/**
	 * https://www.youtube.com/watch?v=M2HFao-zgk8
	 *
	 */
	public int countCharacters(String[] words, String chars) {
		int result = 0;
		int charCount[] = new int[26];
		for (char c : chars.toCharArray())
			charCount[c - 'a']++;//count array

		for (String word : words) { //for every word in input
			int copy[] = Arrays.copyOf(charCount, charCount.length); // create a copy of the word
			int validCharCount = 0; //count valid chars
			for (char c : word.toCharArray()) { //
				if (copy[c - 'a'] > 0) { //if this char exits in chars 
					validCharCount++;
					copy[c - 'a']--;

				}

			}
			if (validCharCount == word.length()) { //if we have sufficient chars 
				result += word.length();

			}

		}
		return result;
	}
}
