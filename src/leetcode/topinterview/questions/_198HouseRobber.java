package leetcode.topinterview.questions;

public class _198HouseRobber {
	private Integer dp[];
	public static void main(String[] args) {
		int a[] = {2,7,9,3,1};
		System.out.println(new _198HouseRobber().efficient(a));
	}
	
	/**
	 * https://www.youtube.com/watch?v=pchOMyPbp0I
	 * 
	 * Idean is whether to take the current index or not take
	 * If we take the current index then max will be cost[curreentIndex]+costTillNow else costTillNow 
	 */
	public int maxBootyRecursion(int a[]) 
	{
		//a is input array , 0 is starting index
		int result = helper(a,0);
		
		return result;
	}
	
	public int helper(int a[], int currentIndex)
	{
		if(currentIndex>=a.length)
		{
			return 0;
			
		}
		int stealFromCurrent = a[currentIndex]+helper(a,currentIndex+2);
		int dontStealFromCurrent = helper(a,currentIndex+1);
		return Math.max(stealFromCurrent, dontStealFromCurrent);
	}
	
	/**
	 * Recursive solution has repetition of results , instead using dp to store the max result till now in array will solve it faster
	 * 
	 */
	public int efficient(int a[])
	{
		 dp = new Integer[a.length];
		return helperDp(a,0);
		
	}
	
	private int helperDp(int a[], int currentIndex) 
	{
		if(currentIndex>=a.length)return 0;
		if(dp[currentIndex]!=null)
		{
			return dp[currentIndex];
			
		}
		
		int stealFromCurrent = a[currentIndex]+helperDp(a,currentIndex+2);
		int dontStealFromCurrent = helperDp(a,currentIndex+1);
		return dp[currentIndex] = Math.max(stealFromCurrent, dontStealFromCurrent);
	}

}
