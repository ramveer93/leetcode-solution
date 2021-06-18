package leetcode.topinterview.questions;

public class _205IsomorphicStrings {

	public static void main(String[] args) {

	}

	/**
	 * https://www.youtube.com/watch?v=iZ2eG3ySN68 s = egg t = add
	 * 
	 * 
	 * map: e->a , g -> d instead map e->1, g->2
	 * 
	 */
	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null)
			return false;
		int m1[] = new int[256]; // extended asciis
		int m2[] = new int[256];

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			if (m1[c1] != m2[c2]) {
				return false;
			}
			m1[c1] = i + 1;
			m2[c2] = i + 1;

		}
		return true;

	}
}
