package adityaverma.stack;

import java.util.Stack;

public class _11MinElementInStackInOone {

	Stack<Integer> stack;
	int minElement;

	public _11MinElementInStackInOone() {
		stack = new Stack<>();
	}

	/**
	 * Design a Data Structure SpecialStack that supports all the stack operations
	 * like push(), pop(), isEmpty(), isFull() and an additional operation getMin()
	 * which should return minimum element from the SpecialStack. All these
	 * operations of SpecialStack must be O(1). To implement SpecialStack, you
	 * should only use standard Stack data structure and no other data structure
	 * like arrays, list, .. etc.
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * 5, 7
	 */
	public void push(int x) {
		if (stack.size() == 0) {
			stack.push(x);
			minElement = x;
		} else {
			if (x > minElement) {
				stack.push(x);
			} else if (x < minElement) {
				stack.push(2 * x - minElement);
				minElement = x;
			}
		}

	}

	public void pop() {
		if (!stack.isEmpty()) {
			if (stack.peek() >= minElement) {
				stack.pop();
			} else if (stack.peek() < minElement) {
				minElement = 2 * minElement - stack.peek();
				stack.pop();
			}
		}
	}

	public int top() {
		if (stack.isEmpty()) {
			return 0;
		} else {
			if (stack.peek() >= minElement) {
				return stack.peek();
			} else if (stack.peek() < minElement) {
				return minElement;

			} else
				return 0;
		}

	}

	public int getMin() {
		return minElement;
	}
}
