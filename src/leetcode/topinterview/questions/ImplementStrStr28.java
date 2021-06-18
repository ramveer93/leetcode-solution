package leetcode.topinterview.questions;

public class ImplementStrStr28 {
	public static void main(String[] args) {

	}

	public int strStr(String haystack, String needle) {
		if (needle.equals("") || needle == null)
			return 0;
		else
			return haystack.indexOf(needle);

	}

}
