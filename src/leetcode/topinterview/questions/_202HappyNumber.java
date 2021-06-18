package leetcode.topinterview.questions;

public class _202HappyNumber {
	public static void main(String[] args) {
		System.out.println(new _202HappyNumber().IsHappyNumber(2));

	}

	/**
	 * same as cycle detection also in linked list
	 * 
	 * 1^2 + 1^2 = 2
		2^2 = 4 ------> notice that from here we are starting with 4
		4^2 = 16
		1^2 + 6^2 = 37
		3^2 + 7^2 = 58
		5^2 + 8^2 = 89
		8^2 + 9^2 = 145
		1^2 + 4^2 + 5^2 = 42
		4^2 + 2^2 = 20
		2^2 + 0^2 = 4 -------> notice that we just get back to 4 again
	 */
	public boolean IsHappyNumber(int n) {
		int slow = n;
		int fast = n;

		while (slow > 1) {
			slow = cal(slow);
			if (slow == 1)
				return true;
			fast = cal(cal(fast));
			if (fast == 1)
				return true;
			if (fast == slow)
				return false;
		}
		return true;
	}

	public int cal(int n) {
		int sum = 0;
		while (n != 0) {
			int rem = n % 10;
			sum = sum + (rem * rem);
			n = n / 10;
		}
		return sum;

	}

}
