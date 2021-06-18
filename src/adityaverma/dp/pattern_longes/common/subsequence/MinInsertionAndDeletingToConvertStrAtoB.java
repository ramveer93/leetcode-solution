package adityaverma.dp.pattern_longes.common.subsequence;

public class MinInsertionAndDeletingToConvertStrAtoB {

	public static void main(String[] args) {
		String x = "leetcode";
		String y = "etco";
		
		System.out.println(new MinInsertionAndDeletingToConvertStrAtoB().minInsertionsAndDeletings(x, y, x.length(), y.length()));
		
	}
	
	/**
	 * heap--------pea
	 *  \         /
	 *   \       /
	 *    \     /
	 *     \   /
	 *      LCS(heap,pea) = ea
	 *      
	 *      
	 *  we will first get lcs of both str
	 *  now will convert x to y via lcs 
	 *  
	 *  to get no of deletions: length(heap)-lcs;
	 *  # of insertions:     length(pea)-lcs;
	 *  
	 *   
	 *   its lcs problem : 1. input and output matching 
	 *   its dp problem: 1-> optimal asked
	 *                   2. choices
	 *                   
	 *                   if any of these true then its dp problem
	 *             
	 *             
	 *             
	 */
	public int minInsertionsAndDeletings(String x, String y, int m , int n) {
		int dp[][] = new int[m+1][n+1];
		/**
		 * initialize first row and col with 0
		 */
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(x.charAt(i-1) == y.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		int lcs = dp[m][n];
		int deletions = m-lcs;
		int insertions = n-lcs;
		System.out.println("deletions: "+deletions+" and insertions: "+insertions);
		
		return deletions+insertions;
		
	}
}
