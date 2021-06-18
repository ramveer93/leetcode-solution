package leetcode.topinterview.questions;

public class _122BestTimeToBuyAndSellStock2 {
	public static void main(String[] args) {
		int a[] = { 7,6,4,3,1 };
		System.out.println(new _122BestTimeToBuyAndSellStock2().maxProfit(a));

	}

	/**
	 * https://www.youtube.com/watch?v=Q-8JkdUliVM&feature=youtu.be
	 */
	public int maxProfit(int a[]) {
		int maxProfit = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[i - 1]) {
				maxProfit = maxProfit + (a[i] - a[i - 1]);
				System.out.println(a[i]-a[i-1]);
			}
		}
		return maxProfit;
	}

}
