package leetcode.topinterview.questions;

public class RemoveElement27 {
	public static void main(String[] args) {

	}

	public int removeElement(int[] nums, int val) {
		if (nums.length == 0)
			return 0;

		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[index++] = nums[i];

			}

		}
		return index;
	}

}
