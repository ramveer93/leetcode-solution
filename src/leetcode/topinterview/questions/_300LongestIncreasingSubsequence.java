package leetcode.topinterview.questions;

public class _300LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int a[] = {2,2 };
		System.out.println(new _300LongestIncreasingSubsequence().lis(a));
	}

	/**
	 * https://www.youtube.com/watch?v=mouCn3CFpgg
	 * 
	 * use dp
	 */
	public int lis(int a[]) {
		int n = a.length;
		 if(n == 0) return 0;
		int dp[] = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = 1;// because every number is a subsequence in itself
			for (int j = 0; j < i; j++) {
				// now compare a[i] and a[j]-> if
				if (a[i] > a[j] && dp[i] < dp[j]+1) {
					dp[i] = 1 + dp[j];

				}
			}

		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > max) {
				max = dp[i];

			}

		}
		// to find out the sub sequence it self , start dp array from last then go till
		// max
		//printLis(dp, a, max);
		return max;

	}

	/**
	 * dp array will be: [1,2,2,1,3] 
	 *                   [0,1,2,3,4]
	 *                   [5,8,7,1,9]
	 * 
	 * @param dp
	 * @param max
	 */
	private void printLis(int dp[], int a[], int max) {

		int index = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] == max) {
				index = i;
				break;
			}
		}
		int count = 1;
		while (index >= 0 && count<=max) {
			System.out.print(a[index]);
			if(index>=0 && dp[index] == dp[index]-1) {
				index = dp[index]-2;
			}
			index = dp[index] - 1;
			count++;
		}

	}
}
