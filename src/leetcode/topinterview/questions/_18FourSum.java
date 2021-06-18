package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _18FourSum {
	public static void main(String[] args) {

	}

	/**
	 * https://www.youtube.com/watch?v=bixvM1-28us
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> fourSum(int nums[], int target) {

		Arrays.sort(nums);

		if (nums.length < 4) {
			return new ArrayList<>();

		}

		Set<List<Integer>> set = new HashSet<>();

		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {

				int left = j + 1;
				int right = nums.length - 1;

				while (left < right) {

					int sum = nums[i] + nums[j] + nums[left] + nums[right];

					if (sum > target) {
						right--;

					} else if (sum < target) {
						left++;

					} else {
						set.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						left++;
						right--;
					}
				}
			}
		}
		return new ArrayList<>(set);
	}

}
