package adityaverma.dp.pattern_longes.common.subsequence;

public class LongestRepeatingSubsequence {

	public static void main(String[] args) {

		String x = "AABEBCDD";
		System.out.println(new LongestRepeatingSubsequence().longestRepeatingSubsequence(x,x.length()));
	}

	/**
	 * https://www.youtube.com/watch?v=hbTaCmQGqLg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30
	 * x: AABEBCDD LRS: -> ABD because ABD is coming two times in x
	 * 
	 * variation: i!=j because if i==j then we are taking both duplicate chars in
	 * just single string
	 */
	public int longestRepeatingSubsequence(String x, int n) {
		String y = x;
		int dp[][] = new int[n + 1][n + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1) && i != j) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}

			}

		}
		
		
		int i=n;
		int j=n;
		String res = "";
		
		while(i>0 && j>0) {
			if(x.charAt(i-1) == y.charAt(j-1) && i!=j) {
				res+=x.charAt(i-1);
				i--;
				j--;
			}else {
				if(dp[i-1][j]>dp[i][j-1]) {
					i--;
				}else {
					j--;
				}
			}
			
		}
		System.out.println("---res-----"+new StringBuffer(res).reverse().toString());
		return dp[n][n];

	}
}
