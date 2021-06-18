package leetcode.topinterview.questions;

import java.util.Arrays;
import java.util.Comparator;

public class _179LargestNumber {
	public static void main(String[] args) {
		int a[] = { 3, 30, 34, 5, 9 };
		System.out.println(new _179LargestNumber().makeLargestNumber(a));

	}

	public String makeLargestNumber(int a[]) {

		String ar[] = new String[a.length];
		for (int i = 0; i < a.length; i++) {
			ar[i] = String.valueOf(a[i]);
		}
		Arrays.sort(ar, new MyComparator());
		if (ar[0].equals("0"))
			return "0";
		StringBuilder sb = new StringBuilder();
		for (String s : ar) {
			sb.append(s);

		}

		return sb.toString();

	}

	class MyComparator implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			String a = o1.toString();
			String b = o2.toString();
			return (b + a).compareTo((a + b));
		}

	}

}
