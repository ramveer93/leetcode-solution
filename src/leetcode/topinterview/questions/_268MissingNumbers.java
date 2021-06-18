package leetcode.topinterview.questions;

public class _268MissingNumbers {
	public static void main(String[] args) {

	}

	public int missingNumbers(int a[]) {
		int n = a.length;
		int shouldBeSum = n * (n + 1) / 2;
		int actualSum = 0;
		for (int i = 0; i < n; i++) {
			actualSum += a[i];
		}
		return shouldBeSum - actualSum;
	}

	public int missingNumberBitManipulation(int a[]) {
		int missing = a.length;
		for (int i = 0; i < a.length; i++) {
			missing = missing ^ i ^ a[i];
		}
		return missing;

	}
}
