package leetcode.topinterview.questions;

/**
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1:
 * 
 * Input: "Let's take LeetCode contest" Output: "s'teL ekat edoCteeL tsetnoc"
 * 
 * Note: In the string, each word is separated by single space and there will
 * not be any extra space in the string.
 * 
 *
 */

public class _557ReverseWordsinaStringIII {

	public static void main(String[] args) {

		System.out.println(new _557ReverseWordsinaStringIII().reverseWords("Let's take LeetCode contest"));
	}

	/**
	 * 
	 */
	public String reverseWords(String s) {
		String temp[] = s.split("\\s");
		String res = "";
		for (int i = 0; i < temp.length; i++) {
			// sb.append(reverse(temp[i]));
			res = res + reverse(temp[i]);
			if (i != temp.length - 1)
				// sb.append(" ");
				res += " ";
		}

		return res;

	}

	public String reverse(String s) {
		String res = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			res = res + s.charAt(i);

		}

		return res;

	}
}
