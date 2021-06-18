package leetcode.topinterview.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import javax.naming.spi.DirStateFactory.Result;

/**
 * 
 * 
 * 
 * 
 * Given a string S, check if the letters can be rearranged so that two
 * characters that are adjacent to each other are not the same.
 * 
 * If possible, output any possible result. If not possible, return the empty
 * string.
 * 
 * Example 1:
 * 
 * Input: S = "aab" Output: "aba"
 * 
 * Example 2:
 * 
 * Input: S = "aaab" Output: ""
 * 
 * @author sramveer
 *
 */
public class _767ReorganizeString {

	public static void main(String[] args) {

		System.out.println(new _767ReorganizeString().reorganize("aaab"));
	}

	// https://www.youtube.com/watch?v=zaM_GLLvysw
	public String reorganize(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

		pq.addAll(map.keySet());

		StringBuffer sb = new StringBuffer();

		while (pq.size() > 1) {
			char first = pq.poll();
			char second = pq.poll();

			sb.append(first);
			sb.append(second);

			map.put(first, map.get(first) - 1);
			map.put(second, map.get(second) - 1);

			if (map.get(first) > 0) {
				pq.add(first);
			}

			if (map.get(second) > 0) {
				pq.add(second);
			}
		}
		
		if(!pq.isEmpty()) {
			char last = pq.poll();
			if(map.get(last)>1) {
				return "";
			}
		    sb.append(last);
		}
		
		return sb.toString();

	}
}
