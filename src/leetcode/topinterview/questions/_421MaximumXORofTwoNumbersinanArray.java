package leetcode.topinterview.questions;

public class _421MaximumXORofTwoNumbersinanArray {

	public static void main(String[] args) {
		int a[] = { 14,70,53,83,49,91,36,80,92,51,66,70 };
		System.out.println(new _421MaximumXORofTwoNumbersinanArray().findMaximumXOR(a));
	}

	public int findMaximumXOR(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (res < (nums[i] ^ nums[j])) {
					res = nums[i] ^ nums[j];
				}

			}

		}

		return res;

	}

}
