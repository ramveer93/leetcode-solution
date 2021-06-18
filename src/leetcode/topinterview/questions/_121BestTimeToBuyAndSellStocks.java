package leetcode.topinterview.questions;

public class _121BestTimeToBuyAndSellStocks {
	public static void main(String[] args) {
		int a[] = { 7, 1, 5, 3, 6, 4 };
		
		System.out.println(new _121BestTimeToBuyAndSellStocks().maxProfitEasy(a));

		System.out.println(new _121BestTimeToBuyAndSellStocks().maxProfit(a));

		System.out.println(new _121BestTimeToBuyAndSellStocks().maxProfitBruteForce(a));

	}

	/**
	 * 
	 * https://www.youtube.com/watch?v=d0PZQWyeGZI&list=PLzffTJx5aHaT-0K_b47KxScckZfDXAKF3&index=2
	 * 
	 * [7,1,5,3,6,4] 
	 * minBuyPrice: 7,1,1,1,1,1 
	 * profit:      0,0,4,2,5,3
	 */

	public int maxProfitEasy(int a[]) {
		int maxProfit = 0;
		int minBuyingPrice = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < minBuyingPrice) {
				minBuyingPrice = a[i];
			}
			if (maxProfit < a[i] - minBuyingPrice) {
				maxProfit = a[i] - minBuyingPrice;
			}

		}
		return maxProfit;

	}

	/**
	 * 
	 * Just have two variables to track minValue(buy value) and max profit
	 * 
	 */
	public int maxProfit(int a[]) {
		int minValue = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] < minValue) {
				minValue = a[i];

			} else if (a[i] - minValue > maxProfit) {
				maxProfit = a[i] - minValue;

			}

		}

		return maxProfit;

	}

	public int maxProfitBruteForce(int a[]) {
		int maxProfit = 0;
		int profit = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				int sellingPrice = a[j];
				int buyPrice = a[i];

				profit = sellingPrice - buyPrice;
				if (profit > maxProfit) {
					maxProfit = profit;

				}

			}

		}
		return maxProfit;

	}

}
