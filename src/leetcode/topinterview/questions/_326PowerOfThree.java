package leetcode.topinterview.questions;

public class _326PowerOfThree {

	public static void main(String[] args) {

		System.out.println(new _326PowerOfThree().isPowerOfThree(45));

	}

	/**
	 * n=3^i i=logn base 3 i = logn base b/log3 base b
	 * 
	 */
	public boolean isPowerOfThree(int n) {
		if (n <= 0)
			return false;
		return (Math.log10(n) / Math.log10(3)) % 1 == 0;
	}
}
