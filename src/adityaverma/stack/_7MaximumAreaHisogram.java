package adityaverma.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Find the largest rectangular area possible in a given histogram where the
 * largest rectangle can be made of a number of contiguous bars. For simplicity,
 * assume that all bars have same width and the width is 1 unit. Refer :
 * https://www.geeksforgeeks.org/largest...
 * 
 * @author sramveer
 *
 */
public class _7MaximumAreaHisogram {

	public static void main(String[] args) {
		int a[] = {6,2,5,4,5,1,6};
		//int a[] = {2,4};
		System.out.println(new _7MaximumAreaHisogram().maxAreaHistogram(a));
		
	}

	/**
	 * 1. find NSL--> left 
	 * 2. find NSR--right 
	 * 3. Width = right-left-1 
	 * 4. Area: a[i]*width
	 */
	public int maxAreaHistogram(int a[]) {
		List<Integer> right = nsr(a);
		List<Integer> left = nsl(a);
		System.out.println("right: "+right.toString());
		System.out.println("left: "+left.toString());

		int maxArea = 0;
		for (int i = 0; i < a.length; i++) {
			maxArea = Math.max(maxArea, (right.get(i) - left.get(i) - 1) * a[i]);
		}
		return maxArea;
	}

	private List<Integer> nsl(int a[]) {
		List<Integer> res = new ArrayList<>();
		Stack<Pair> s = new Stack<>();
		for (int i = 0; i < a.length; i++) {
			if (s.size() == 0) {
				res.add(-1);
			} else if (s.size() > 0 && s.peek().getNge() < a[i]) {
				res.add(s.peek().getIndex());
			} else if (s.size() > 0 && s.peek().getNge() >= a[i]) {
				while (s.size() > 0 && s.peek().getNge() >= a[i]) {
					s.pop();
				}
				if (s.size() == 0) {
					res.add(-1);
				} else {
					res.add(s.peek().getIndex());
				}
			}
			s.add(new Pair(a[i], i));
		}
		return res;
	}

	// nsr: it has right so start with right and it has smaller so user <
	private List<Integer> nsr(int a[]) {
		List<Integer> res = new ArrayList<>();
		Stack<Pair> s = new Stack<>();
		for (int i = a.length - 1; i >= 0; i--) {
			if (s.size() == 0) {
				res.add(a.length );
			} else if (s.size() > 0 && s.peek().getNge() < a[i]) {
				res.add(s.peek().getIndex());
			} else if (s.size() > 0 && s.peek().getNge() >= a[i]) {
				while (s.size() > 0 && s.peek().getNge() >= a[i]) {
					s.pop();
				}
				if (s.size() == 0) {
					res.add(a.length );
				} else {
					res.add(s.peek().getIndex());
				}

			}
			s.add(new Pair(a[i], i));
		}
		Collections.reverse(res);
		return res;
	}
}
