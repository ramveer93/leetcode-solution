package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=h6FmiyYDjmk easy solution
 * 
 * 
 * https://www.youtube.com/watch?v=imD5XeNaJXA
 * 
 * 
 * 
 * https://www.youtube.com/watch?v=GqE96uMPOLI
 * 
 * 
 * @author sramveer
 *
 */

public class _17LetterCombinationOfAPhoneNumber {
	public static void main(String[] args) {
		System.out.println(letterCombination("23").toString());
	}

	/**
	 * https://www.youtube.com/watch?v=imD5XeNaJXA
	 * inefficient method 
	 * @param digits
	 * @return
	 */
	public static List<String> getItDone(String digits) {
		LinkedList<String> result = new LinkedList<>();
		if (digits.isEmpty()) {
			return result;
		}
		String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		result.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (result.peek().length() == i) {
				String t = result.remove();
				for (char s : mapping[x].toCharArray()) {
					result.add(t + s);
				}
			}
		}
		return result;
	}

	/**
	 * https://www.youtube.com/watch?v=h6FmiyYDjmk
	 * 
	 * Efficient method
	 * 
	 * https://www.youtube.com/watch?v=GqE96uMPOLI
	 * 
	 * 
	 * 
	 * @return
	 */
	public static List<String> letterCombination(String digits) {
		List<String> result = new ArrayList<>();

		if (digits.length() == 0 || digits.equals("")) {
			return result;

		}
		Map<Character, char[]> mapping = new HashMap<>();

		mapping.put('0', new char[] {});
		mapping.put('1', new char[] {});
		mapping.put('2', new char[] { 'a', 'b', 'c' });
		mapping.put('3', new char[] { 'd', 'e', 'f' });
		mapping.put('4', new char[] { 'g', 'h', 'i' });
		mapping.put('5', new char[] { 'j', 'k', 'l' });
		mapping.put('6', new char[] { 'm', 'n', 'o' });
		mapping.put('7', new char[] { 'p', 'q', 'r', 's' });
		mapping.put('8', new char[] { 't', 'u', 'v' });
		mapping.put('9', new char[] { 'w', 'x', 'y', 'z' });

		StringBuilder sb = new StringBuilder();
		helper(digits, mapping, sb, result);
		return result;

	}

	private static void helper(String digits, Map<Character, char[]> mapping, StringBuilder sb, List<String> result) {
		if (digits.length() == sb.length()) {
			result.add(sb.toString());
			return;
		}
		for (char c : mapping.get(digits.charAt(sb.length()))) {
			sb.append(c);
			helper(digits, mapping, sb, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
