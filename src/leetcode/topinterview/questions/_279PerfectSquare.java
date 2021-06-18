package leetcode.topinterview.questions;

public class _279PerfectSquare {

	public static void main(String[] args) {

		System.out.println(new _279PerfectSquare().numSquares(13));
	}

	/**
	 * https://www.youtube.com/watch?v=1xfx6M_GqFk
	 * 
	 * dp[i] = i dp[i] = min(dp[i], dp[i-j*j]+1);
	 * 
	 */
	public int numSquares(int n) {
		int dp[] = new int[n + 1];
		for(int i=0;i<=n;i++)
		dp[i] = i;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);

			}

		}
		return dp[n];
	}
}
