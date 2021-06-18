package leetcode.topinterview.questions;

public class _55JumpGame {

	public static void main(String[] args) {
	//	int a[] = { 2, 3, 1, 1, 4 };
		int a[] = { 3, 2, 1, 0, 4 };
		System.out.println(new _55JumpGame().isJumpable(a));
		System.out.println(new _55JumpGame().backtracking(a));
		
		
	}

	/**
	 * https://www.youtube.com/watch?v=2HnlGToCdCc
	 * 
	 * 
	 * 
	 * idea is to start from last index and 
	 * keep checking if i+a[i]>=lastGoodIndex
	 * then lastGooodIndex = i; 
	 * return true if we get lastGooodIndex as 0
	 * 
	 * @param a
	 * @return
	 * 
	 * 		[2,3,1,1,4]
	 * 
	 * 
	 * EFFICIENT SOLUTION
	 */
	public boolean isJumpable(int a[]) {
		int lastGoodIndex = a.length - 1;
		for (int i = a.length - 1; i >= 0; i--) {
			if (i + a[i] >= lastGoodIndex) {
				lastGoodIndex = i;
			}
		}
		return lastGoodIndex == 0;
	}
	
	
	
	
	public boolean backtracking(int a[])
	{
		return helper(0,a);
		
	}

	private boolean helper(int position, int[] a) {
		if(position == a.length-1)
		{
			return true;
			
		}
		int furtherPosition = Math.min(position+a[position], a.length-1);
		for(int i = furtherPosition;i>position;i--)
		{
			if(helper(i,a)) {
				return true;
			}
			
		}
		return false;
	}
}
