package leetcode.topinterview.questions;

public class _14LongestCommonPrefix {
	public static void main(String[] args) {
		//System.out.println(longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
		System.out.println(lcp(new String[] { "flower", "flow", "flight" }));
		
		

	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0 || strs == null) {
			return "";
		}
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].equals("")) {
				return "";

			}

		}
		String lcp = strs[0];
		String result = "";
		for (int i = 1; i < strs.length; i++) {

			int j = 0;
			int size = Math.min(strs[i].length(), lcp.length());
			while (j < size) {
				if (lcp.charAt(j) == strs[i].charAt(j)) {
					result = result + Character.toString(strs[i].charAt(j));
					j++;
					if (j == size) {
						lcp = result;
						result = "";

					}
				} else {
					lcp = result;
					result = "";
					break;
				}

			}
		}
		return lcp;

	}

	/**
	 * https://www.youtube.com/watch?v=fhyIORFDD0k&t=1s [apple, apps, ape]: ap
	 */
	public static String lcp(String a[]) {
		String result = "";
		int n = a.length;

		if (a.length == 0) {
			return result;
		}
		int minLength = minLength(a);
		char current;
		for (int i = 0; i < minLength; i++) { // for every char in min string
			current = a[0].charAt(i);
			for (int j = 1; j < n; j++) { //for every word except the first one 
				if (a[j].charAt(i) != current) {
					return result;
				}
			}
			result = result + (current);

		}

		return result;

	}

	private static int minLength(String a[]) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			int size = a[i].length();
			if (size < min) {
				min = size;
			}
		}
		return min;

	}

}
