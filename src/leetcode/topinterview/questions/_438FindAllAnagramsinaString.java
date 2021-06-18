package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _438FindAllAnagramsinaString {

	public static void main(String[] args) {

		System.out.println(new _438FindAllAnagramsinaString().findAnagrams("cbaebabacd", "abc").toString());
	}

	/**
	 * https://www.youtube.com/watch?v=36kPB5c_9cY
	 * 
	 * sliding window
	 */
	public List<Integer> findAnagrams(String s, String p) {

		List<Integer> res = new ArrayList<>();
		if (s.length() < p.length())
			return res;
		int st = 0;
		int end = p.length() - 1;
		Map<Character, Integer> hms = new HashMap<>();
		Map<Character, Integer> hmp = new HashMap<>();

		// build hmp first
		for (int i = 0; i < p.length(); i++) {
			char r = p.charAt(i);
			hmp.put(r, hmp.getOrDefault(r, 0) + 1);
		}

		// now build hms
		for (int i = 0; i <= end; i++) {
			char t = s.charAt(i);
			hms.put(t, hms.getOrDefault(t, 0) + 1);
		}

		if (hms.equals(hmp))
			res.add(st);
		st++;
		end++;
		while (end < s.length()) {
			// add the next char to hms

			char next = s.charAt(end);
			hms.put(next, hms.getOrDefault(next, 0) + 1);

			// remove previous char from hms
			char prev = s.charAt(st - 1);
			if (hms.containsKey(prev)) {
				hms.put(prev, hms.getOrDefault(prev, 0) - 1);
				if (hms.get(prev) == 0) {
					hms.remove(prev);
				}
			}
			if (hms.equals(hmp))
				res.add(st);
			st++;
			end++;

		}

		return res;

	}
}
