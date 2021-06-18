package leetcode.topinterview.questions;

import java.util.Stack;

public class _84LargestRectangleInHistogram {
	public static void main(String[] args) {
		int a[] = {0, 1 };
		System.out.println(new _84LargestRectangleInHistogram().findMaxArea(a));

	}

	/**
	 * 
	 * 
	 * https://www.youtube.com/watch?v=ZmnqCZp9bBs
	 * 
	 */
	public int findMaxArea(int a[]) {
		int i;
		int area = 0;
		int maxArea = 0;
		if (a.length == 0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		for (i = 0; i < a.length;) {
			if (stack.isEmpty() || a[stack.peek()] <= a[i]) {
				stack.add(i++);
			} else {
				int top = stack.pop();
				if (stack.isEmpty()) {
					area = a[top] * i;
				} else {
					area = a[top] * (i - stack.peek() - 1);
				}
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		while (!stack.isEmpty()) {
			int top = stack.pop();
			if (stack.isEmpty()) {
				area = a[top] * i;
			} else {
				area = a[top] * (i - stack.peek() - 1);
			}
			if (area > maxArea) {
				maxArea = area;

			}
		}
		return maxArea;

	}

}
