package adityaverma.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The stock span problem is a financial problem where we have a series of n
 * daily price quotes for a stock and we need to calculate span of stock’s price
 * for all n days. The span Si of the stock’s price on a given day i is defined
 * as the maximum number of consecutive days just before the given day, for
 * which the price of the stock on the current day is less than or equal to its
 * price on the given day. For example, if an array of 7 days prices is given as
 * {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days
 * are {1, 1, 1, 2, 1, 4, 6}
 * 
 * 
 * for any element find consecutive smaller element including that element also
 * 
 *days: 1   2    3   4  5   6   7}  
 *    {100, 80, 60, 70, 60, 75, 85}
 *    {1,1,1,2,1,4,6}
 *    
 *    lets say on 3 find smaller numbers to its left icluding itself: there is just one number
 *  
 *  so we have to find the nearest greater to left 
 *     {100, 80, 60, 70, 60, 75, 85}
 *in   {0,    1,  2,  3,  4,  5, 6}
 *  
 * ngl {100, 100,80, 80, 70, 80,100}
 *  
 *     {0,1,1,2,1,4,6}
 *     
 *     so for every element we have to find the ngl and - the current index with 
 *     ngl index
 *     for e.x: for 85 its index = 6 
 *              its ngl = 100
 *              its ngl index = 0
 *              so ans = its index - ngl index = 6-0 = 6
 *  
 * 
 * https://www.youtube.com/watch?v=p9T-fE1g1pU&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=6
 * 
 * @author sramveer
 *
 */
public class _6StockSpanProblem {

	public static void main(String[] args) {
		int a[] = { 10, 80, 60, 70, 60, 75, 85 };
		new _6StockSpanProblem().stockSpan(a);
	}

	/**
	 * This is equal to nearest greater to left
	 */
	public List<Integer> stockSpan(int a[]) {
		List<Integer> res = new ArrayList<>();
		Stack<Pair> s = new Stack<>();
		for (int i = 0; i < a.length; i++) {
			if (s.size() == 0) {
				res.add(-1);
			} else if (s.size() > 0 && s.peek().getNge() > a[i]) {
				res.add(s.peek().getIndex());
			} else if (s.size() > 0 && s.peek().getNge() <= a[i]) {
				while (s.size() > 0 && s.peek().getNge() <= a[i]) {
					s.pop();
				}
				if (s.size() == 0) {
					res.add(0);
				} else {
					res.add(s.peek().getIndex());
				}

			}
			s.add(new Pair(a[i], i));
		}
		System.out.println(res.toString());
		List<Integer> temp = new ArrayList<>();

		for (int i = 0; i < a.length; i++) {
			temp.add(i - res.get(i));
		}
		System.out.println(temp.toString());
		return temp;
	}
}

class Pair {
	int nge;
	int index;

	Pair(int nge, int index) {
		this.nge = nge;
		this.index = index;
	}

	public int getNge() {
		return nge;
	}

	public void setNge(int nge) {
		this.nge = nge;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
