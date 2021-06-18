package adityaverma.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _5NearestSmallerToRight {

	public static void main(String[] args) {
		int a[] = { 4, 5, 2, 10, 8 };
		System.out.println(new _5NearestSmallerToRight().nsr(a));
	}

	public List<Integer> nsr(int a[]) {
		List<Integer> res = new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		for (int i = a.length - 1; i >= 0; i--) {
			if (s.size() == 0) {
				res.add(-1);
			} else if (s.size() > 0 && s.peek() < a[i]) {
				res.add(s.peek());
			} else if (s.size() > 0 && s.peek() >= a[i]) {
				while (s.size() > 0 && s.peek() >= a[i]) {
					s.pop();
				}
				if (s.size() == 0) {
					res.add(-1);
				} else {
					res.add(s.peek());
				}

			}
			s.add(a[i]);
		}
		Collections.reverse(res);
		return res;
	}
}
