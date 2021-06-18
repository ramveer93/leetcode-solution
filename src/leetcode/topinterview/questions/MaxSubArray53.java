package leetcode.topinterview.questions;

public class MaxSubArray53 {

	public static void main(String[] args) {
		int a[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(new MaxSubArray53().bruteForce(a));
		System.out.println(new MaxSubArray53().efficient(a));

	}

	/**
	 * https://www.youtube.com/watch?v=hPWJNoaI7t8
	 * 
	 * idea is to get the running sum , set the sum to 0 whenever sum<0 
	 * 
	 * 
	 * @param a
	 * @return
	 */
	public int efficient(int[] nums) 
    {
        if(nums.length ==0) return 0;
        if(nums.length == 1) return nums[0];
        int maxSum = nums[0];
        int sum = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            
            if(sum<0)
            {
                sum = nums[i];
                //or we can assign it to 0
                
            }else{
                sum = sum+nums[i];
            }
            maxSum = Math.max(sum, maxSum);
            
            
        }
        return maxSum;
        
    }

	/**
	 * 
	 * idea is to take sum of all the arrays from given array and take max sum out
	 * of that
	 * 
	 * @param a
	 * @return
	 */
	public int bruteForce(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int maxSum = nums[0];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j <= i; j++) {
				maxSum = Math.max(maxSum, sum(nums, j, i));

			}

		}
		return maxSum;

	}

	private int sum(int a[], int i, int j) {
		int sum = 0;
		for (int k = i; k <= j; k++) {

			sum += a[k];
		}
		return sum;
	}

}
