package leetcode.topinterview.questions;

import java.util.HashMap;
import java.util.Map;

public class _395LongestSubstringwithAtLeastKRepeatingCharacters {

	public static void main(String[] args) {

		System.out.println(new _395LongestSubstringwithAtLeastKRepeatingCharacters().longestSubstring("aaabb", 3));
	}

	/**
	 * https://www.youtube.com/watch?v=bHZkCAcj3dc
	 */
	public int longestSubstring(String s, int k) {
		// base cases
		int n = s.length();
		if (s == null || n == 0) {
			return 0;
		}
		if (k <= 1) {
			return n;
		}

		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int l = 0;
		while (l < n && map.get(s.charAt(l)) >= k) {
			l++;
		}
		if (l >= n - 1)
			return l;// that means we have same chars in the string
		int length1 = longestSubstring(s.substring(0, l), k);
		while (l < n && map.get(s.charAt(l)) < k) { // we will skip this char as this can't contribute on result
			l++;
		}

		int length2 = l < n ? longestSubstring(s.substring(l), k) : 0;

		return Math.max(length1, length2);

	}
}
