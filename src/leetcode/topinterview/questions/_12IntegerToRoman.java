package leetcode.topinterview.questions;

public class _12IntegerToRoman {
	static String[] ones = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
	static String[] thousands = { "", "M", "MM", "MMM" };
	static String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
	static String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };

	public static void main(String[] args) {

		System.out.println(intToRoman(1000));

	}

	public static String intToRoman(int number) {

		String result = "";
		if (number / 1000 > 0) {
			result += thousands[number / 1000];
			number = number % 1000;

		}
		if (number / 100 > 0) {
			result += hundreds[number / 100];
			number = number % 100;
		}
		if (number / 10 > 0) {
			result += tens[number / 10];
			number = number % 10;
		}
		if (number > 0) {
			result += ones[number];

		}

		return result;

	}

}
