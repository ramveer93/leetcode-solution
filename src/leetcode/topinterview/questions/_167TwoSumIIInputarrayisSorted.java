package leetcode.topinterview.questions;

public class _167TwoSumIIInputarrayisSorted {

	public static void main(String[] args) {
		int a[] = {2,7,11,15};
		System.out.println(new _167TwoSumIIInputarrayisSorted().twoSum(a, 9));
	}
	public int[] twoSum(int[] numbers, int target) {
		int start = 0;
		int end = numbers.length - 1;
		while (start < end) {
			int sum = numbers[start] + numbers[end];
			if (sum == target) {
				break;
			} else if (sum > target) {
				end--;
			} else {
				start++;
			}

		}
		return new int[] { start + 1, end + 1 };
	}
}
