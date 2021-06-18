package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _377CombinationSumIV {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3 };
		System.out.println(new _377CombinationSumIV().combinationSum4DP(a, 4));

	}

	/**
	 * https://www.youtube.com/watch?v=PomVtsn7ZoM
	 */
	public int combinationSum4Recursion(int a[], int target) {
		if (target == 0)
			return 1;
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			if (target >= a[i]) {
				result = result + combinationSum4Recursion(a, target - a[i]);
			}

		}
		return result;
	}
	
	public int combinationSum4DP(int a[], int target) {
		int dp[] = new int[target+1];
		dp[0] = 1; // ways to generate target 0 are 1
		for(int i = 1;i<dp.length;i++) {//i is the target
			for(int j = 0;j<a.length;j++) {//j is the elements in a
				if(i>=a[j]) {
					dp[i] = dp[i]+dp[(i-a[j])];
				}
				
			}
		}
		return dp[target];
		
	}
	
	
	

}
