package leetcode.topinterview.questions;

import java.util.HashMap;
import java.util.Map;

public class _309BestTimetoBuyandSelStockwithCooldown {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 0, 2 };
		System.out.println(new _309BestTimetoBuyandSelStockwithCooldown().maxProfit(a));
	}

	/**
	 * https://www.youtube.com/watch?v=N-zlfQJWbYE&t=53s
	 * 
	 * buy or not buy sell or not sell max of both
	 * 
	 */
	public int maxProfit(int a[]) {
	
		// a is input array
		// 0 is index in array
		// 0 is to indicate this is to buy
		// 1 is to sell
		Map<String, Integer> hm = new HashMap<>();
		return helper(a, 0, 0, hm);

	}

	public int helper(int a[], int i, int buyOrSell, Map<String, Integer> hm) {
		if (i >= a.length) {
			return 0;
		}
		String key = i + "" + buyOrSell;
		if (hm.containsKey(key))
			return hm.get(key);
		int max = 0;
		if (buyOrSell == 0) { // we have to buy
			int buy = helper(a, i + 1, 1, hm) - a[i];
			int dontBuy = helper(a, i + 1, 0, hm);
			max = Math.max(buy, dontBuy);
		} else { // we have to sell
			int sell = helper(a, i + 2, 0, hm);
			int dontSell = helper(a, i + 1, 1, hm) + a[i];
			max = Math.max(sell, dontSell);
		}
		hm.put(key, max);
		return max;

	}
}
