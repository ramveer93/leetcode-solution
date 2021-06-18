package leetcode.topinterview.questions;

import java.util.Random;

public class _384ShuffleanArray {

	private int[] nums;
	Random random;

	public _384ShuffleanArray(int nums[]) {
		this.nums = nums;
		random = new Random();

	}

	public int[] reset() {
		return nums;
	}

	public int[] shuffle() {
		if (this.nums == null)
			return null;
		int temp[] = this.nums.clone();
		for (int j = 1; j < nums.length; j++) {
			int i = random.nextInt(j + 1);
			swap(temp, i, j);

		}
		return temp;
	}

	private void swap(int temp[], int i, int j) {
		int t = temp[i];
		temp[i] = temp[j];
		temp[j] = t;

	}

	public static void main(String[] args) {

	}

}
