package leetcode.topinterview.questions;

import java.util.Stack;

public class _394DecodeString {

	public static void main(String[] args) {
		System.out.println(new _394DecodeString().decode("3[a2[c]]"));
	}

	/**
	 * https://www.youtube.com/watch?v=0iQqj5egK9k
	 */
	public String decode(String s) {
		String res = "";
		Stack<Integer> numbers = new Stack<>();
		Stack<String> strs = new Stack<>();
		int index = 0;
		while (index < s.length()) {
			
			if (Character.isDigit(s.charAt(index))) { // when number
				int numb = 0;
				while (Character.isDigit(s.charAt(index))) {
					numb = numb * 10 + (s.charAt(index) - '0');
					index++;
				}
				numbers.add(numb);
				
			} else if (s.charAt(index) == '[') { // when opening bracket, push to stack
				strs.add(res);
				index++;
				res = "";
			} else if (s.charAt(index) == ']') { // when closing , pop
				StringBuffer temp = new StringBuffer(strs.pop());
				int count = numbers.pop();
				for (int i = 0; i < count; i++) {
					temp.append(res);
				}
				res = temp.toString();
				index++;
			} else { // when char
				res += s.charAt(index);
				index++;
			}
		}
		return res;
	}
}
