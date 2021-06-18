package leetcode.topinterview.questions;

import java.util.HashSet;
import java.util.Set;

public class _3LongestSubstringWithoutRepeatingCharacters {

	/**
	 * https://www.youtube.com/watch?v=WKTgajDkVcA
	 * 
	 * idea is using a sliding window technique
	 * keep adding to set untill we have any duplicates in window 
	 * remove from start whenever we found any duplicates in set
	 */
	public int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0, max = 0;
		Set<Character> set = new HashSet<>();

		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				max = Math.max(max, set.size());
				j++;

			} else {
				set.remove(s.charAt(i));
				i++;
			}

		}
		return max;

	}
	
}
