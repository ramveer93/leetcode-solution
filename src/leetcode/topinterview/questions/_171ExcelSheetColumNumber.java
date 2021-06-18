package leetcode.topinterview.questions;

public class _171ExcelSheetColumNumber {

	public static void main(String[] args) {
		System.out.println(new _171ExcelSheetColumNumber().titleToNumber("ZY"));
	}
	/**
	 * We will have to convert the 26 base number to decimal , just the way we do
	 * for binary number to decimal number convrsion
	 */
	public int titleToNumber(String s) {
		int result = 0;
		int i = s.length() - 1;
		int p = 0;
		while (i >= 0) {
			result = (int) (result + ((s.charAt(i) - 'A')+1) * Math.pow(26, p++));
			i--;

		}
		return result;

	}

}
