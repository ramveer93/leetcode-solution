package leetcode.topinterview.questions;

public class _172FactorialTrailingZeroes {

	public static void main(String[] args) {
		System.out.println(new _172FactorialTrailingZeroes().trailingZeroes(100000));
	}
	
	public int trailingZeroes(int n) {
		int result = 0;
		int i = 0;
		int p = 1;
		while (i <= n) {
			result = (int) (result + (n / Math.pow(5, p++)));
			i++;
		}
		return result;

	}

}
