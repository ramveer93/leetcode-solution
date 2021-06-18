package leetcode.topinterview.questions;

public class StringToInteger {
	public static void main(String[] args) {
		System.out.println(myAtoi("3.14159"));
	}

	public static int myAtoi(String str) {
		String numbers = "0123456789";
		str = str.trim();
		if (str.startsWith("-") || str.startsWith("0") || str.startsWith("1") || str.startsWith("2")
				|| str.startsWith("3") || str.startsWith("4") || str.startsWith("5") || str.startsWith("6")
				|| str.startsWith("7") || str.startsWith("8") || str.startsWith("9")) {
			String s = "";
			int decimalIndex = str.indexOf(".");
			if (decimalIndex > -1) {
				s = str.substring(0, decimalIndex);

			} else {
				for (char c : str.toCharArray()) {
					if (numbers.contains(Character.toString(c))) {
						s = s + c;
					}
				}
			}

			try {
				return (str.startsWith("-")) ? -Integer.parseInt(s) : Integer.parseInt(s);
			} catch (NumberFormatException e) {
				return Integer.MIN_VALUE;

			}

		} else {
			return 0;
		}

	}

}
