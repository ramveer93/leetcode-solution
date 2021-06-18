package leetcode.topinterview.questions;

import java.util.Arrays;

public class _581ShortestUnsortedContinuousSubarray {

	public static void main(String[] args) {

		int a[] = {1,2,3,4};
		System.out.println(new _581ShortestUnsortedContinuousSubarray().findUnsortedSubarray(a));
		System.out.println(new _581ShortestUnsortedContinuousSubarray().findUnsortedSubarray2(a));
	}
	/**
	 * https://www.youtube.com/watch?v=B_Z9Xx_sNDg
	 * 
	 */
	 public int findUnsortedSubarray2(int[] nums) {
	        int start = 0;
	        int end = 0;
	        int clone[] = nums.clone();
	        Arrays.sort(clone);
	        
	       for(int i=0;i<clone.length;i++) {
	    	   if(nums[i]!=clone[i]) {
	    		   start = i;
	    		   break;
	    	   }
	    	   
	       }
	        
	       for(int j=clone.length-1;j>=0;j--) {
	    	   if(nums[j]!=clone[j]) {
	    		   end = j;
	    		   break;
	    	   }
	    	   
	       }
	        
	        return end==start?0:end-start+1;
	    }

	public int findUnsortedSubarray(int a[]) {
		int start = 0;
		int end = 0;
		int clone[] = a.clone();
		Arrays.sort(clone);

		// find start first
		for (int i = 0; i < clone.length; i++) {
			if (a[i] != clone[i]) {
				start = i;
				break;
			}

		}

		// find end
		for (int i = clone.length - 1; i >= 0; i--) {
			if (a[i] != clone[i]) {
				end = i;
				break;
			}
		}

		return end - start + 1;

	}
}
