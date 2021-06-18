package adityaverma.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _2NearestGreaterToRight {

	public static void main(String[] args) {
		int a[] = { 1, 3, 2, 4 };
		int t[] = new _2NearestGreaterToRight().bruteForce(a);
		for (int i = 0; i < t.length; i++)
			System.out.println(t[i]);

		System.out.println(new _2NearestGreaterToRight().efficient(a).toString());
	}

	/**
	 * Here j is depending on i so stack can be applied
	 */
	public int[] bruteForce(int a[]) {
		int res[] = new int[a.length];
		int k = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] < a[j]) {
					res[k++] = a[j];
					break;
				}
			}
		}
		res[k] = -1;
		return res;

	}

	/**
	 * { 1, 3, 2, 4 };
	 * 
	 * 
	 * conditions:   1. stack empty ===> res -1
	 *               2. stack peek>a[i] ===> res stack peek 
	 *               3. stack peek <=a[i] ===> while -> stack peek greater than a[i] and
	 * stack is not empty
	 * 
	 * 
	 */
	public List<Integer> efficient(int a[]) {
		List<Integer> res = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();

		for (int i = a.length - 1; i >= 0; i--) {
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
		Collections.reverse(res);

		return res;
	}
}
