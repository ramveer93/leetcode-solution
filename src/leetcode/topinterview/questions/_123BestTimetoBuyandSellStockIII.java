package leetcode.topinterview.questions;

public class _123BestTimetoBuyandSellStockIII {

	
	public static void main(String[] args) {
		int a[] = {1,3,0,5,2,5,3,7};
		System.out.println(new _123BestTimetoBuyandSellStockIII().maxProfit(a));
	}
	/**
	 * https://www.youtube.com/watch?v=GFa9xlgZcEI&list=PLzffTJx5aHaT-0K_b47KxScckZfDXAKF3&index=13
	 * we can do at most 2 transactions
	 *
	 *
	 *
	 *   1------3  0-----5    2---5   3----7
	 *   
	 *   b1: 0
	 *   p1: 5
	 *   b2: 3-5 = -2
	 *   p2: 7--2 = 9
	 *
	 *
	 *
	 *
	 */
	public int maxProfit(int prices[]) {
		int b1 = Integer.MAX_VALUE;
		int b2 = Integer.MAX_VALUE;
		int p1 = 0;
		int p2 = 0;

		for (int i = 0; i < prices.length; i++) {
			b1 = Math.min(b1, prices[i]);
			p1 = Math.max(p1, prices[i] - b1);
			b2 = Math.min(b2, prices[i] - p1);
			p2 = Math.max(p2, prices[i] - b2);

		}

		return p2;
	}
}
