package adityaverma.dp.pattern_knapsack;

public class _6CountNooFSubsetsWithGivenDiff {

	public static void main(String[] args) {
		int w[] = {1,1,2,3};
		System.out.println(new _6CountNooFSubsetsWithGivenDiff().countNoOfSubsetsWithGiivenDiff(w, 1));
	}
	
	/**
	 * https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11
	 * 
	 * 
	 * 
	 * s1-s2=diff
	 * s1+s2 = sum
	 * 2s1 = (diff+sum)
	 * s1 = (diff+sum)/2;
	 * 
	 * so subset sum with s1 as sum
	 */
	public int countNoOfSubsetsWithGiivenDiff(int w[], int diff) {
		int sum = 0;
		for(int i=0;i<w.length;i++)sum+=w[i];
		
		int s1 = (diff+sum)/2;
		int dp[][] = new int[w.length+1][s1+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(i==0)dp[i][j] = 0;
				if(j==0)dp[i][j] = 1;
				
			}
			
		}
		//dp[0][0] = 1;
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(w[i-1]<=j) {
					dp[i][j] = dp[i-1][j-w[i-1]]+dp[i-1][j];
					
				}else {
					dp[i][j] = dp[i-1][j];
				}
				
			}
			
		}
		return dp[w.length][s1];
		
	}
}
