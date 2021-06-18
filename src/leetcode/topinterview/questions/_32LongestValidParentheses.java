package leetcode.topinterview.questions;

import java.util.Stack;

public class _32LongestValidParentheses {

	public static void main(String[] args) {

		System.out.println(new _32LongestValidParentheses().longestValidParanthesis("(()())(((()))()()())"));
	}

	/**
	 * https://www.youtube.com/watch?v=qC5DGX0CPFA
	 * 
	 * Idea is to maintain two stacks one to store characters and another to store
	 * index
	 * 
	 * when : ( -> push to char stack and push its index to index stack
	 * 
	 * when : ) -> check if stack peek is ( then pop the char from stack and index
	 * from index and calculate max lengjt
	 * 
	 */
	public int longestValidParanthesis(String s) {
		Stack<Character> charStack = new Stack<>();
		Stack<Integer> index = new Stack<>();
		index.add(-1);
		int maxLength = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				charStack.add('(');
				index.add(i);
			} else { // )
				if (!charStack.isEmpty() && charStack.peek() == '(') {
					charStack.pop();
					index.pop();
					maxLength = Math.max(maxLength, i - index.peek());

				} else {
					index.add(i); // when we dont have any closing bracket , just update the index to index stack
				}

			}

		}
		return maxLength;

	}
}
