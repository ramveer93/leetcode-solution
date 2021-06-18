package leetcode.topinterview.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=Xy1dfcg7P-Y
 * 
 * @author sramveer
 *
 */

public class _13RomanToInteger {
	static Map<Character, Integer> map = new HashMap<>();

	public static void main(String[] args) {

	}

	public int romanToInt(String s) {
		if (s.length() == 0 || s == null) {
			return 0;

		}
		/**
		 * initialize the map
		 */
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int length = s.length();
		int result = map.get(s.charAt(length - 1));
		for (int i = length - 2; i >= 0; i--) {
			if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
				result += map.get(s.charAt(i));
			} else {
				result = result - map.get(s.charAt(i));
			}
		}
		return result;
	}

}
