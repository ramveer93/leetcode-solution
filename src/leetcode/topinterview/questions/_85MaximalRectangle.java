package leetcode.topinterview.questions;

import java.util.Stack;

public class _85MaximalRectangle {

	public static void main(String[] args) {

		int input[][] = { { '0', '1' }, { '1', '0' } };
		System.out.println(new _85MaximalRectangle().maxRectangle(input));
	}

	/**
	 * https://www.youtube.com/watch?v=g8bSdXCG-lA 
	 * 
	 * 
	 * Idea is to take every row and
	 * calculate area of rectangle and update the max area
	 */
	public int maxRectangle(int a[][]) {

		int maxArea = 0;
		int rows = a.length;
		int area = 0;
		if (rows == 0)
			return 0;
		int cols = a[0].length;
		int temp[] = new int[cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (a[i][j] == '0') {
					temp[j] = 0;
				} else {
					temp[j] = temp[j] + Character.getNumericValue(a[i][j]);
				}
			}
			area = maxAreaOfHistogram(temp);
			if (area > maxArea) {
				maxArea = area;
			}
		}

		return maxArea;

	}

	public int maxAreaOfHistogram(int a[]) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		int area = 0;
		int i;
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
