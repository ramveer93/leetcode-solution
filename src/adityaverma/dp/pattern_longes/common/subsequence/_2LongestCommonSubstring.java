package adityaverma.dp.pattern_longes.common.subsequence;

public class _2LongestCommonSubstring {

	public static void main(String[] args) {

		String x = "abdsddsdsdsdsdsdssd";
		String y = "abd";
		System.out.println(new _2LongestCommonSubstring().dp(x, y, x.length(), y.length()));
	}

	/**
	 * https://www.youtube.com/watch?v=HrybPYpOvz0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=22
	 */
	public int dp(String x, String y, int n, int m) {
		int dp[][] = new int[n+1][m+1];
		String res = "";
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(x.charAt(i-1) == y.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
				}else {
					dp[i][j] = 0;
				}
				
			}
		}
		int max = 0;
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				max = Math.max(max, dp[i][j]);
			}
			
		}
		
		System.out.println(res);
		return max;
	}
	
	
	
	
	
}
