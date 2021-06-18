package adityaverma.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _3NearestGreaterToLeft {

	public static void main(String[] args) {
		int a[] = { 100, 80, 60, 70, 60, 75, 85 };
		System.out.println(new _3NearestGreaterToLeft().ngl(a));

	}

	/**
	 * Changes from _2
	 * 1.start from i=0
	 * 2. dont reverse the list
	 * @param a
	 * @return
	 */
	public List<Integer> ngl(int a[]) {
		List<Integer> res = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < a.length; i++) {
			if (stack.size() == 0) {
				res.add(-1);
			} else if (stack.size() > 0 && stack.peek() > a[i]) {
				res.add(stack.peek());
			} else if (stack.size() > 0 && stack.peek() <= a[i]) {
				while (stack.size() > 0 && stack.peek() <= a[i]) {
					stack.pop();
				}
				if (stack.size() == 0) {
					res.add(-1);
				} else {
					res.add(stack.peek());
				}

			}
			stack.add(a[i]);
		}
		return res;
	}
}
