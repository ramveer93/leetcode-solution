package companies;

import java.util.ArrayList;
import java.util.List;

public class Skellam {

	public static void main(String[] args) {
//		String s1 = "abcbdbdb";
//		String s2 = "bdbd";
		//System.out.println(new Skellam().containsInstr(s1, s2));
		
		char c[][] = {
				{'a','b','c','d'},
				{'b','c','d','d'},
				{'a','c','b','d'}
				};
		String s = "abcd";
		
		System.out.println(new Skellam().isValid(c, s));

		/**
		 * 4 rows 4 cols 
		 * intput: abcd 
		 * [ a b c d] 
		 * [ b c d d] 
		 * [ a c b d]
		 * 
		 * same row: a[i][j+1] same col: a[i+1][j-1]
		 * 
		 * if(a[i]==m[i][j] || a[i]==m[][]){ }
		 */

	}

	private boolean isValid(char[][] a, String s) {
		int rows = a.length;
		int cols = a[0].length;
		int k = 0;
		int count = 0;
		for (int i = 0; i < rows-1; i++) {
			for (int j = 0; j < cols && k<s.length(); j++) {
				char c = s.charAt(k);
					if (a[i][j] == c || c == a[i][j + 1] || c == a[i + 1][j]) {
						count++;
						k++;
					}
			}
		}
		return count == s.length();

	}

	private boolean containsInstr(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		if (s2.isEmpty()) {
			return true;
		}
		if (s2.length() > s1.length()) {
			return false;
		}
		if (s2.length() == 1) {
			for (char c : s1.toCharArray()) {
				if (c == s2.charAt(0)) {
					return true;
				}

			}
			return false;
		}
		List<String> list = new ArrayList<>();
		for (int i = 0; i < s1.length(); i++) {
			for (int j = i + 1; j < s1.length(); j++) {
				String temp = s1.substring(i, j + 1);
				if (temp.length() == s2.length()) {
					list.add(temp);
				}

			}

		}

		for (String s : list) {
			if (s.equals(s2)) {
				return true;
			}
		}
		return false;

	}

	public boolean contains(String s1, String s2) {
		// return s1.contains(s2);
		boolean res = false;

		int index = s1.indexOf(s2.charAt(0));
		if (index == -1) {
			return false;
		}
		int i = 1;
		int j = index + 1;
		while (i < s2.length() && j < s1.length()) {
			if (s2.charAt(i) == s1.charAt(j)) {
				i++;
				j++;
			} else if (s2.charAt(i) != s1.charAt(j)) {
				return false;
			}

		}
		return true;

	}

}
