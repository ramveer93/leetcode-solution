package leetcode.topinterview.questions;

public class _188BestTimetoBuyandSellStockIV {

	public static void main(String[] args) {

		int a[] = {3,2,6,5,0,3};
		System.out.println(new _188BestTimetoBuyandSellStockIV().maxProfit(a, 2));
	}

	/**
	 * https://www.youtube.com/watch?v=thGK0PjLemk&list=PLzffTJx5aHaT-0K_b47KxScckZfDXAKF3&index=14
	 * 
	 * We have to complete k transactions
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 1 transaction: part 1: one min and one max return max
	 * 
	 * 2 transaction: part 3: b1,b2,p1,p2
	 * 
	 * many transaction: part 2: keep adding all the profits
	 * 
	 * 
	 * 
	 * max transactions we can perform will be prices.length/2
	 * 
	 * 
	 * 
	 */
	public int maxProfit(int prices[], int k) {
		if (k == 0 || prices.length == 0)
			return 0;
		if (k >= prices.length / 2) {
			// we can perform many transactions so the code of part 2 goes here
			int maxProfit = 0;
			for (int i = 1; i < prices.length; i++) {
				if (prices[i] > prices[i - 1]) {
					maxProfit += prices[i] - prices[i - 1];

				}

			}
			return maxProfit;

		}

		// 1 transaction
		int maxProfit = 0;
		int minBuy = Integer.MAX_VALUE;
		int profits[] = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			minBuy = Math.min(minBuy, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - minBuy);
			profits[i] = maxProfit;

		}

		// for 3 transactions
		for (int i = 1; i < k; i++) {
			ktimes(prices, profits);

		}

		int ans = 0;
		for (int i = 0; i < profits.length; i++) {
			ans = Math.max(ans, profits[i]);

		}
		return ans;

	}

	private void ktimes(int prices[], int profits[]) {
		int b2 = Integer.MAX_VALUE;
		int p2 = 0;
		for (int i = 0; i < prices.length; i++) {

			b2 = Math.min(b2, prices[i] - profits[i]);
			p2 = Math.max(p2, prices[i] - b2);
			profits[i] = p2;
		}

	}
}
