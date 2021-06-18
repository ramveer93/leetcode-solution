package leetcode.topinterview.questions;

import java.util.Stack;

public class _739DailyTemperature {

	public static void main(String[] args) {

		int t[] = {73, 74, 75, 71, 69, 72, 76, 73};
		int a[] = new _739DailyTemperature().dailyTemperature(t);
		for(int i=0;i<a.length;i++)System.out.println(a[i]);
	}

	/**
	 * https://www.youtube.com/watch?v=WGm4Kj3lhRI&feature=youtu.be
	 * 
	 * if incoming element is greater than stack peek then pop from stack else push
	 * to stack , add stack peek-current index to result
	 */
	public int[] dailyTemperature(int[] T) {

		int res[] = new int[T.length];
		if (T.length == 0)
			return res;
		Stack<Integer> stack = new Stack<>();// store only index

		for (int i = T.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
				stack.pop();

			}
			res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
			stack.push(i);

		}

		return res;

	}
}
