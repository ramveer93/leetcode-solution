package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

public class _66PlusOne {

	public static void main(String[] args) {
		int a[] = { 9 };
		// int t[] = new _66PlusOne().plusOneNumber(a);
		int t[] = new _66PlusOne().plusOne(a);
		for (int i = 0; i < t.length; i++) {
			System.out.println(t[i]);

		}

	}

	public int[] plusOneNumber(int a[]) {
		StringBuilder sb = new StringBuilder();
		List<Integer> res = new ArrayList<>();
		if (a.length == 0)
			return new int[0];
		for (int i = 0; i < a.length; i++) {
			sb = sb.append(a[i]);

		}
		long number = Long.parseLong(sb.toString());
		number = number + 1;
		String s = String.valueOf(number);
		for (int i = 0; i < s.length(); i++) {
			res.add(s.charAt(i) - '0');

		}

		return res.stream().mapToInt(Integer::intValue).toArray();

	}

	public int[] plusOneEfficient(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				digits[i]++;
				break;

			} else {
				digits[i] = 0;
			}

		}
		if (digits[0] == 0) {
			int res[] = new int[digits.length + 1];
			res[0] = 1;
			return res;

		}
		return digits;

	}

	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				digits[i]++;
				break;
			} else {
				digits[i] = 0;
			}
		}
		if (digits[0] == 0) {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			return res;
		}
		return digits;
	}

}
