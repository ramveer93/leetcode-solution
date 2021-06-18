package leetcode.topinterview.questions;

public class _151ReverseWordsinaString {

	public static void main(String[] args) {

		System.out.println(new _151ReverseWordsinaString().reverseWords("  hello world  "));
	}

	public String reverseWords(String s) {
		String res = "";
		// <spaces>hello world<spaces>
		String words[] = s.trim().split(" +");//what does the "+" in split(" +") do? means multiple whitespaces
		for (int i = words.length - 1; i >= 0; i--) {
			String temp = words[i];
			
			temp = temp.trim();
			if (temp !=" " && temp!="" ) {
				res = res + temp;
				if (i != 0) {
					res = res + " ";

				}
			}

		}

		return res.trim();
	}
}
