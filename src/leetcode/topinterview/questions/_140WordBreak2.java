package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _140WordBreak2 {

	public static void main(String[] args) {

		String s = "pineapplepenapple";
		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("pen");
		list.add("applepen");
		list.add("pine");
		list.add("pineapple");
		// list.add("apple");

		System.out.println(new _140WordBreak2().wordBreak(s, list).toString());
	}

	/**
	 * Problem is to convert the s into space separated sentence but we need to see
	 * if there are more combination of that word
	 * 
	 * https://www.youtube.com/watch?v=necF6yyegiE
	 * 
	 * we need to use hash map as there are repetition
	 * 
	 */
	public List<String> wordBreak(String s, List<String> dict) {
		// string, startIndex, dict
		Set<String> hs = new HashSet<>(dict);
		Map<Integer, List<String>> hm = new HashMap<>();

		return helper(s, 0, hs, hm);

	}

	public List<String> helper(String s, int start, Set<String> hs, Map<Integer, List<String>> hm) {

		List<String> res = new ArrayList<>();
		if (hm.containsKey(start)) {
			return hm.get(start);

		}

		if (start == s.length()) {
			res.add("");

		}
		// now search all sub strings in hs
		for (int end = start + 1; end <= s.length(); end++) {
			String prefix = s.substring(start, end);
			if (hs.contains(prefix)) // then solve the remaining problem
			{
				List<String> suffixes = helper(s, end, hs, hm); // suffixes will be having list of words but we need to
																// make
																// sentence
				// now make a sentences
				for (String suffix : suffixes) {
					String sentence = prefix + (suffix.equals("") ? "" : " ") + suffix;
					res.add(sentence);

				}

			}

		}
		hm.put(start, res);
		return res;

	}

}
