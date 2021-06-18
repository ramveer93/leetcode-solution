package adityaverma.stack;

import java.util.Stack;

//https://www.youtube.com/watch?v=asf9P2Rcopo&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=10
/**
 * Design a Data Structure SpecialStack that supports all the stack operations
 * like push(), pop(), isEmpty(), isFull() and an additional operation getMin()
 * which should return minimum element from the SpecialStack. All these
 * operations of SpecialStack must be O(1). To implement SpecialStack, you
 * should only use standard Stack data structure and no other data structure
 * like arrays, list, .. etc.
 * 
 * @author sramveer
 *
 */
public class _9MinElementInStack {

	private Stack<Integer> stack;
	private Stack<Integer> min;

	public _9MinElementInStack() {
		stack = new Stack<>();
		min = new Stack<>();
	}

	public static void main(String[] args) {
		int a[] = { 18, 19, 29, 15, 16 };
		_9MinElementInStack obj = new _9MinElementInStack();
			obj.push(18);
			obj.push(19);
			System.out.println(obj.getMin());
			obj.push(29);
			obj.push(15);
			System.out.println(obj.getMin());
			System.out.println(obj.pop());
			obj.push(16);
			System.out.println(obj.getMin());
		
	}

	/**
	 * push to stack every time 
	 * push to minStack every time : min of (peek of minStack, item)
	 * @param element
	 */
	public void push(int element) {
		stack.push(element);
		if (min.isEmpty()) {
			min.push(element);
		} else{
			int t = Math.min(element, min.peek());
			min.push(t);
		}

	}

	public int pop() {
		int item = 0;
		if (!stack.isEmpty()) {
			item = stack.pop();
			min.pop();
		}
		
		return item;
	}

	public int top() {
		return stack.peek();
	}
	public int getMin() {
		if (min.isEmpty())
			return 0;
		else
			return min.peek();
	}
}
