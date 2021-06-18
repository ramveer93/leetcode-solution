package leetcode.topinterview.questions;

import java.util.Stack;

public class _227BasicCalculatorII {
	public static void main(String[] args) {

		System.out.println(new _227BasicCalculatorII().calculat("3+5 / 2"));
	}

	/**
	 * first make a number from given chars: number = number*10+charAt(i)-'0'; // do
	 * this only if the char is digit else it is any one of these: +, -, /, * in
	 * case of +, just push the number to stack in case of - , just push the -number
	 * to stack in case of *, pop from stack * number to stack in case of /, pop
	 * from stack /number now at the end just keep applying the + operator to the
	 * numbers
	 */
	public int calculat(String s) {
		int number = 0;
		Stack<Integer> stack = new Stack<>();
		char sign = '+';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				number = (number * 10) + c - '0';
			}
			if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() - 1) { // that means it will be
				if (sign == '+') {
					stack.add(number);
				}
				if (sign == '-') {
					stack.add(-number);
				}
				if (sign == '*') {
					stack.add(stack.pop() * number);
				}
				if (sign == '/') {
					stack.add(stack.pop() / number);
				}
				number = 0;
				sign = c;
			}
		}
		int res = 0;
		for (Integer itr : stack) {
			res += itr;

		}

		return res;
	}

}
