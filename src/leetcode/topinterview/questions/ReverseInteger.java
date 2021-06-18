package leetcode.topinterview.questions;

public class ReverseInteger {
	public int reverse(int x) {
		String s = String.valueOf(x);
		boolean negative = false;

		if (s.charAt(0) == '-') {
			negative = true;
			s = s.substring(1, s.length());
		}

		StringBuilder sb = new StringBuilder(s);

		try {
			return negative ? -Integer.parseInt(sb.reverse().toString()) : Integer.parseInt(sb.reverse().toString());
		} catch (NumberFormatException e) {
			return 0;

		}

	}

}
