package leetcode.topinterview.questions;

/**
 * 
 * 
 * Similar questions: 62. Unique Paths 70. Climbing Stairs 509. Fibonacci Number
 * 
 * 
 * 
 * @author sramveer
 *
 */
public class _91DecodeWays {

	public static void main(String[] args) {
		System.out.println(new _91DecodeWays().efficient(""));
	}

	/**
	 * 
	 * 
	 * 
	 * e.g: 12321 c(12321) = c(1232)+c(123) c(1232) = c(123)[c(12)can't come as 32
	 * is outside range of alphabets] c(123) = c(12)+c(1) c(12) = c(1)+c("") c(1) =
	 * c("")
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * numsOfEncoding(msg) = numsEncoding(msg,n-1)+numsEncoding(msg,n-2)[if
	 * msg[n-2][n-1] in range [1..26]]
	 * 
	 * https://www.youtube.com/watch?v=aCKyFYF9_Bg
	 * 
	 * 
	 * https://www.youtube.com/watch?v=qli-JCrSwuk
	 */
	public int bruteForce(String s) {

		return helper(s, s.length());

	}

	public int helper(String s, int k) {
		if (k == 0)
			return 1;
		if (k >= s.length())
			return 1;
		int index = s.length() - k;

		if (s.charAt(index) == '0')
			return 0;

		int result = helper(s, k - 1);
		if (k >= 2 && Integer.parseInt(s.substring(2)) <= 26) {
			result += helper(s, k - 2);
		}
		return result;

	}

	public int efficient(String s) {

		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = ((s.charAt(0) == '0') ? 0 : 1);
		for (int i = 2; i <= s.length(); i++) {
			int oneDigit = Integer.valueOf(s.substring(i - 1, i));
			int twoDigit = Integer.valueOf(s.substring(i - 2, i));
			if (oneDigit > 0) {
				dp[i] = dp[i] + dp[i - 1];

			}

			if (twoDigit >= 10 && twoDigit <= 26) {
				dp[i] = dp[i] + dp[i - 2];
			}

		}

		return dp[s.length()];

	}

}
