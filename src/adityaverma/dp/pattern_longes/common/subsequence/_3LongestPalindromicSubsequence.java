package adityaverma.dp.pattern_longes.common.subsequence;

public class _3LongestPalindromicSubsequence {

	public static void main(String[] args) {
		String x = "agbcba";
		System.out.println(new _3LongestPalindromicSubsequence().lps(x));
		
	}
	
	
	
	/**
	 * Can we apply lcs:
	 * 1. input -> str x, str y vs str x  not matching
	 * 2. question: lcs vs lps  partially matching
	 * 3. output: int vs int fully matching so getting 1/3 score it should be at least 2/3 still lcs will apply here 
	 * 
	 * 
	 * 
	 * All we have to do is to find the second string 
	 * if we reverse x then we will have second str 
	 * 
	 * 
	 * x: agbcba
	 * y: abcbga
	 * 
	 * lcs: abcba which is lps also 
	 */
	public int lps(String x) {
		String y = new _3LongestPalindromicSubsequence().reverse(x);
		int m = x.length();
		int n = y.length();
		
		int dp[][] = new int[m+1][n+1];
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(x.charAt(i-1) == y.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
				
			}
			
		}
		
		int lcs  = dp[m][n];
		
		
		int i = m;
		int j = n;
		String res = "";
		while(i>0 && j>0) {
			if(x.charAt(i-1) == y.charAt(j-1)) {
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
		
		System.out.println(res);
		
		return lcs;
		
		
	}
	
	
	
	
	
	public  String reverse(String x) {
		char a[] = x.toCharArray();
		int start = 0;
		int end = x.length() - 1;

		while (start < end) {
			char c = a[start];
			a[start] = a[end];
			a[end] = c;
			start++;
			end--;
		}
		return new String(a);

	}

	
}
