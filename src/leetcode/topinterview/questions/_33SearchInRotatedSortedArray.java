package leetcode.topinterview.questions;

public class _33SearchInRotatedSortedArray {
	public static void main(String[] args) {

		int a[] = {4,5,6,7,0,1,2};
		System.out.println(new _33SearchInRotatedSortedArray().search(a, 0));
	}

	
	
	
	
	/**
	 * https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14436/Revised-Binary-Search
	 * 
	 */
	public int search(int [] nums, int target) {
		
		int left = 0;
		int right = nums.length-1;
		while(left<=right) {
			int mid = left+(right-left)/2;
			if(nums[mid] == target) return mid;
			
			//case 1: when left is monotonically increeasing, that means pivot is in right part , drop the right part
			if(nums[left]<=nums[mid]) {
				if(target>=nums[left] && target<nums[mid]) {
					right = mid-1;
					
				}else {
					left = mid+1;
				}
				
			}else { //2: when right is monotonically increeasing, 
//				that means pivot is in left part , drop the left part
				//nums[mid]<=nums[right]
				if(target>nums[mid] && target<=nums[right]) {
					left = mid+1;
					
				}else {
					right = mid-1;
				}
				
			}
			
		}
		
		return -1;
		
	}
	/**
	 * Ideea is to find the pivot element first in O(n) then apply the binary search
	 * in both the parts -> 0 to pivot and pivot+1 to a.length-1
	 * 
	 * @param a
	 * @param target
	 * @return
	 */

	public int searchNonEfficient(int[] nums, int target) {

		int pivot = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				pivot = i;
				break;
			}
		}

		int firstHalf = bsRecursive(nums, 0, pivot, target);
		int secondHalf = bsRecursive(nums, pivot + 1, nums.length - 1, target);

		if (firstHalf != -1)
			return firstHalf;
		else
			return secondHalf;

	}

	public int bsRecursive(int nums[], int left, int right, int k) {
		if (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == k)
				return mid;
			else if (nums[mid] < k)
				return bsRecursive(nums, mid + 1, right, k);
			else
				return bsRecursive(nums, left, mid - 1, k);

		}
		return -1;

	}

	public int bs(int nums[], int k) {
		int left = 0;
		int right = nums.length - 1;
		int mid = (left + right) / 2;
		while (left <= right) {
			if (nums[mid] == k) {
				return mid;

			} else if (nums[mid] < k) {
				left = mid + 1;

			} else {
				right = mid - 1;
			}

		}
		return -1;

	}

}
