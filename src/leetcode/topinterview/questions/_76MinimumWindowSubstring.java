package leetcode.topinterview.questions;

import java.util.Arrays;

public class _76MinimumWindowSubstring {
	public static void main(String[] args) {
		//System.out.println(new _76MinimumWindowSubstring().bruteForce("ADOBECODEBANC", "ABC"));
		System.out.println(new _76MinimumWindowSubstring().efficient("ABCDEFDIVGHIJKLMNICPCOPQRSTUVWXYZO" + 
				"", "ABCDEFGHIJKLMNOPQRSTUVWXYZ").length());
	}

	/**
	 * first watch this : https://www.youtube.com/watch?v=7LiyJGmY73A
	 * https://www.youtube.com/watch?v=b9OgfHDFNlo
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public String efficient(String s, String target) {
		String minString = "";
		int minLength = Integer.MAX_VALUE;
		int countOfTinS = 0;
		int countArray[] = new int[128];
		for (char c : target.toCharArray()) {
			countArray[c]++; // mark the counts of T seen in count Array

		}

		//take two pointers i and j 
		int i = 0;
		for (int j = 0; j < s.length(); j++) {
			if (--countArray[s.charAt(j)] >= 0) {
				countOfTinS++;

			}
			// shrink the found string now 
			while (countOfTinS == target.length()) {
				// we have found a substring
				int currentLength = j - i + 1;
				if (currentLength < minLength) {

					minLength = currentLength;
					minString = s.substring(i, j + 1);
				}
				if (++countArray[s.charAt(i)] > 0) {

					countOfTinS--;
				}
				i++;

			}

		}

		return minString;

	}

	/**
	 * idea is to generate all the sub strings of length target and then sort both
	 * target and substring , check if substring contains target
	 * 
	 * @param s
	 * @param target
	 * @return
	 */
	public String bruteForce(String s, String target) {
		String res = s;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String temp = s.substring(i, j);
				// System.out.println(temp);
				if (temp.length() >= target.length()) {
					// System.out.println("string found...."+temp);
					String substr = temp;
					char a[] = substr.toCharArray();
					Arrays.sort(a);
					substr = new String(a);

					char b[] = target.toCharArray();
					Arrays.sort(b);

					String targetStr = new String(b);
					if (substr.contains(targetStr)) {
						if (temp.length() <= res.length()) {
							res = temp;
						}
					}
				}
			}
		}
		return res;

	}

}
