package leetcode.topinterview.questions;

public class _38CountAndSay {

	public static void main(String[] args) {
		System.out.println(new _38CountAndSay().cAndS(3));
	}

	public String cAndS(int n) {
		String res = "1";

		for (int i = 1; i < n; i++) {
			res = doThis(res);

		}

		return res;

	}

	public String doThis(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
				sb.append(count);
				sb.append(s.charAt(i - 1));
				count = 1;
			} else {
				count++;
			}

		}
		sb.append(count);
		sb.append(s.charAt(s.length() - 1));
		return sb.toString();

	}


}
