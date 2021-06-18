package leetcode.topinterview.questions;

import java.util.Arrays;

public class _322CoinChange {

	public static void main(String[] args) {
		int denoms[] = { 1, 2, 5 };
		System.out.println(new _322CoinChange().coinChange(denoms, 11));

	}

	/**
	 * https://www.youtube.com/watch?v=jgiZlGzXMBw&feature=emb_title 
	 * 
	 * how many min coins to make amount
	 */
	public int coinChange(int denoms[], int amount) {

		int dp[] = new int[amount + 1];
		Arrays.fill(dp, amount + 1); // fill all the values to amount+1
		dp[0] = 0;

		for (int i = 1; i <= amount; i++) { // till amount
			for (int j = 0; j < denoms.length; j++) {
				if (denoms[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i - denoms[j]] + 1);
				}

			}

		}

		return dp[amount] > amount ? -1 : dp[amount];
	}
}
