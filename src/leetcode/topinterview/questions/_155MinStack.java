package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _155MinStack {
	/** initialize your data structure here. */
	Stack<Integer> stack;
	List<Integer> mins;

	public _155MinStack() {
		stack = new Stack<>();
		mins = new ArrayList<>();
	}

	/**
	 * This approach will be O(1) time and O(n) space
	 * 
	 * https://www.youtube.com/watch?v=8UegNFCUQks
	 * 
	 * Idea is to maintain a separate list which will have min number
	 */
	public static void main(String[] args) {

		_155MinStack s = new _155MinStack();
		s.push(10);
		s.push(100);
		s.push(2);
		s.push(56);
		s.push(90);
		s.push(45);
		s.push(12);
		System.out.println(s.getMin());

	}

	/**
	 * in stack add the element x But in list , we need to add
	 * min(x,list.get(list.size()-1));
	 */
	public void push(int x) {
		stack.add(x);
		if (mins.size() > 0) {
			int y = mins.get(mins.size() - 1);
			mins.add(Math.min(y, x));
		} else {
			mins.add(x);
		}

	}

	/**
	 * pop from stack remove from list also from last
	 */
	public void pop() {
		stack.pop();
		mins.remove(mins.size() - 1);

	}

	/**
	 * return top of stack
	 */
	public int top() {

		return stack.peek();

	}

	/**
	 * return from list , last element of list
	 */
	public int getMin() {
		return mins.get(mins.size() - 1);

	}

}
