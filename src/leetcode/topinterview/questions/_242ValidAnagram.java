package leetcode.topinterview.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _242ValidAnagram {

	public static void main(String[] args) {

	}

	/**
	 * Sort both strings and compare every char
	 */
	public boolean validAnagramSort(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		char c1[] = s1.toCharArray();
		Arrays.sort(c1);
		char c2[] = s2.toCharArray();
		Arrays.sort(c2);
		for (int i = 0; i < c1.length; i++) {
			if (c1[i] != c2[i]) {
				return false;
			}

		}
		return true;
	}

	/**
	 * build a map with key as char and value as frequency
	 * 
	 * 
	 */
	public boolean validAnagramhashMap(String s1, String s2) {
		if (s1.length() == 0 && s2.length() == 0)
			return true;
		Map<Character, Integer> map = new HashMap<>();
		if (s1.length() != s2.length()) {
			return false;
		}
		for (int i = 0; i < s1.length(); i++) {
			map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
			map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
		}
		for (char c : map.keySet()) {
			if (map.get(c) != 0)
				return false;
		}

		return true;
	}
}
