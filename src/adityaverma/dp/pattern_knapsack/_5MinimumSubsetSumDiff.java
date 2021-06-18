package adityaverma.dp.pattern_knapsack;

import java.util.ArrayList;
import java.util.List;


public class _5MinimumSubsetSumDiff {

	public static void main(String[] args) {
		int w[] = {1,2,7};
		System.out.println(new _5MinimumSubsetSumDiff().subsetSumMinDiff(w, w.length));
	}
	
	/**
	 * https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
	 * 
	 * 
	 * 
	 * find two subsets s1 and s2 from array where s1-s2 or s2-s1 is min.
	 * e.ge {1,2,7}
	 * s1: {1,2}=>3
	 * s2: {7}=>7
	 * diff 7-3 = 4 which is min difference 
	 * 
	 * 
	 * 
	 * 
	 * Thought process: 
	 * 
	 * s1-s2 min-> 0<-----s1--------|--------s2-------->10
	 * we can write s2 = 10-s1 or s2 = range-s1
	 * so we have to minimize s1-s2 = > s1-range-s1 = > |range-2s1|
	 * so we have to min range-2s1
	 * we know the range but we are clueless about s1, but we know the range of s1 : 
	 * that will be 0 to 10 , but we also know not all the numbers in that range will be part of s1
	 * 
	 * e.g: only numbers: 1,2,3,7,8,9,10 will be part of s1 
	 * 
	 * also we can take n/2 elements only in s1
	 * 
	 * we can find s1 elements by using subset sum dp's last row
	 * which is if n->i and j-> 0 to 10
	 * 
	 * Once we have all the numbers of s1 we can just get min number such that range-2s1 is min.
	 * 
	 * 0<----------------|---------------->10
	 */
	public int subsetSumMinDiff(int w[], int n) {
		int range = 0;
		for(int i=0;i<n;i++)range+=w[i];
		
		//now will find s1 elements using subset sum
		
		boolean dp[][] = new boolean[n+1][range+1];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(i==0)dp[i][j] = false;
				if(j==0)dp[i][j] = true;
				
			}
		}
		dp[0][0] = true;
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(w[i-1]<=j) {
					dp[i][j] = dp[i-1][j-w[i-1]] ||dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j];
				}
				
			}
			
		}
		
		List<Integer>temp = new ArrayList<>();
		for(int i=0;i<(dp[0].length)/2;i++) {
			if(dp[n][i]) {
				temp.add(i);
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<temp.size();i++) {
			min = Math.min(min, range-2*temp.get(i));
		}
		
		return min;
		
		
	}
}
