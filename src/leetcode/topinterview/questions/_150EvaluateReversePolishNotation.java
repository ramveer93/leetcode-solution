package leetcode.topinterview.questions;

import java.util.Stack;

public class _150EvaluateReversePolishNotation {

	public static void main(String[] args) {
		String a[] = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };

		System.out.println(new _150EvaluateReversePolishNotation().evaluate(a));

	}

	/**
	 * prefix is polish notation +3 4 postfix is reverse polish notation : 3 4 +
	 * 
	 * The idea is whenever we have operands we will push that to stack , whenever
	 * we have an operator , pop 2 items from stack and apply the operator and push
	 * the result to stack
	 * 
	 * 
	 */
	public int evaluate(String tokens[]) {
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			if (!isOperator(tokens[i])) {
				stack.add(tokens[i]);
			} else {
				int a = Integer.parseInt(stack.pop());
				int b = Integer.parseInt(stack.pop());
				int result = 0;
				switch (tokens[i]) {
				case "+":
					result = a + b;
					break;
				case "-":
					result = b - a;
					break;
				case "/":
					result = (a == 0) ? 0 : b / a;
					break;
				case "*":
					result = a * b;
					break;
				}
				stack.add(String.valueOf(result));
			}

		}
		return Integer.parseInt(stack.pop());

	}

	public boolean isOperator(String s) {
		if (s.equals("+") || s.equals("-") || s.endsWith("/") || s.equals("*"))
			return true;
		return false;

	}

}
