package adityaverma.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _4NearestSmallerToLeft {
	public static void main(String[] args) {
		int a[] = { 4, 5, 2, 10, 8 };
		System.out.println(new _4NearestSmallerToLeft().nsl(a));
	}

	public List<Integer> nsl(int a[]) {
		List<Integer> res = new ArrayList<>();
		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < a.length; i++) {
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
		return res;
	}
}
