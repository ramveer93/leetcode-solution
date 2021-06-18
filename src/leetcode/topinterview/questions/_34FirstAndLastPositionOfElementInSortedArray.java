package leetcode.topinterview.questions;

public class _34FirstAndLastPositionOfElementInSortedArray {

	public int[] searchRange(int[] nums, int target) {

		int left = bsLeftRight(nums, target, true);
		int right = bsLeftRight(nums, target, false);

		return new int[] { left, right };

	}

	/**
	 * https://www.youtube.com/watch?v=zr_AoTxzn0Y
	 * 
	 * 
	 * 
	 * the idea is to search the element in left part and right part of bst 
	 * @param a
	 * @param target
	 * @param isLeft
	 * @return
	 */
	public int bsLeftRight(int a[], int target, boolean isLeft) {
		int left = 0;
		int right = a.length - 1;
		int index = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (a[mid] == target) {
				index = mid;
				if (isLeft) {
					right = mid - 1;

				} else {
					left = mid + 1;
				}

			} else if (a[mid] < target) {
				left = mid + 1;

			} else {
				right = mid - 1;
			}

		}
		return index;

	}

//	public int bsIterativeLeft(int nums[], int target) {
//		int left = 0;
//		int right = nums.length - 1;
//		int mid = left + (right - left) / 2;
//		int index = -1;
//
//		while (left <= right) {
//			if (nums[mid] == target) {
//				index = mid;
//				right = mid - 1;
//
//			} else if (nums[mid] < target) {
//				left = mid + 1;
//
//			} else {
//				right = mid - 1;
//			}
//
//		}
//		return index;
//
//	}

//	public int bsIterativeRight(int nums[], int target) {
//		int left = 0;
//		int right = nums.length - 1;
//		int mid = left + (right - left) / 2;
//		int index = -1;
//
//		while (left <= right) {
//			if (nums[mid] == target) {
//				index = mid;
//				left = mid + 1;
//
//			} else if (nums[mid] < target) {
//				left = mid + 1;
//
//			} else {
//				right = mid - 1;
//			}
//
//		}
//		return index;
//
//	}

}
