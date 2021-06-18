package leetcode.topinterview.questions;

import java.util.Stack;

public class _277FindTheCelebrity {

	public static void main(String[] args) {

	}

	/**
	 * https://www.youtube.com./watch?v=5rkKCrPzD8c
	 * 
	 * Celebrity: All knows this man , But he doesn't know anyone
	 * 
	 * a[i][j] = 0 means i doesn't know j
	 * 
	 * Idea is to create a stack , push all the elements in stack , take out two
	 * elements find possible celebrity
	 */
	public int findCelebrity(int a[][], int n) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			stack.add(i);
		}
		// Check for possible celebritys
		while (stack.size() > 1) { // Remove from stack until the size of stack is one
			int x = stack.pop();
			int y = stack.pop();
			if (a[x][y] == 0) {
				stack.add(x);
			} else {
				stack.add(y);
			}
		}

		int k = stack.pop();
		// now check if he satisy the celebrity conditions
		for (int i = 0; i < n; i++) {
			if (a[i][k] == 0 || a[k][i] == 1) {
				return -1;
			}

		}
		return k;
	}
}
