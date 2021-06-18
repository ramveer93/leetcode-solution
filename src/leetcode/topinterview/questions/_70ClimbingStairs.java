package leetcode.topinterview.questions;

public class _70ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(new _70ClimbingStairs().climbWaysRecursive(45));
		System.out.println(new _70ClimbingStairs().climbWaysDp(45));
	}

	public int climbWaysDp(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <=n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];

		}
		return dp[n];
	}

	/**
	 * 
	 * 
	 * if n = 0, then there is no way to climb stairs =>0 n = 1-> there is only one
	 * way n = 2 -> there are two ways---> 1+1,2 n = 3-> there are three ways --->
	 * (1+1+1),(1+2),(2+1)
	 * 
	 * so f(n) = f(n-1)+f(n-2)
	 * 
	 * 
	 * @param n
	 * @return
	 */
	public int climbWaysRecursive(int n) {
		if (n == 0) {
			return 0;

		} else if (n == 1) {
			return 1;

		} else if (n == 2) {
			return 2;

		} else {
			return climbWaysRecursive(n - 1) + climbWaysRecursive(n - 2);
		}

	}

}
