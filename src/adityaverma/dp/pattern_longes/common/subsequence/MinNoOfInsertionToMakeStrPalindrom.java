package adityaverma.dp.pattern_longes.common.subsequence;

public class MinNoOfInsertionToMakeStrPalindrom {

	public static void main(String[] args) {
		String x = "aebcbda";
		System.out.println(new MinNoOfInsertionToMakeStrPalindrom().minNoOfInsertionToMakeStrPalindrom(x));
	}
	
	/**
	 * x = aebcbda
	 * 
	 * we have done min no of deletion to make it palindrom in which x.leng - lps 
	 * here min del was e and d
	 * 
	 * also min insertion will be same as e and d to make it palindrom 
	 * so min insertion = min deletiong
	 */
	public int minNoOfInsertionToMakeStrPalindrom(String x ) {
		String y = new _3LongestPalindromicSubsequence().reverse(x);
		int m = x.length();
		int n = y.length();
		int dp[][] = new int[m+1][n+1];
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(x.charAt(i-1) == y.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			
		}
		return m-dp[m][n];
	}
}
