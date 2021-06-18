package leetcode.topinterview.questions;

import java.util.Stack;

public class _20ValidParanthesis {
	public static void main(String[] args) {
		System.out.println(IsValid("]"));
	}

	public static boolean IsValid(String input) {
		Stack<Character> stack = new Stack<>();
		/**
		 * if there is any opening bracket put it into stack
		 */
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
				stack.push(input.charAt(i));

			} else {
				/**
				 * take from stack
				 */
				if (stack.isEmpty())
					return false;
				char fromStack = stack.pop();

				if (fromStack == '{' && input.charAt(i) == ']' || fromStack == '{' && input.charAt(i) == ')') {
					return false;

				}
				if (fromStack == '(' && input.charAt(i) == ']' || fromStack == '(' && input.charAt(i) == '}') {
					return false;

				}
				if (fromStack == '[' && input.charAt(i) == '}' || fromStack == '[' && input.charAt(i) == ')') {
					return false;

				}
			}

		}
		return stack.isEmpty();

	}

}
