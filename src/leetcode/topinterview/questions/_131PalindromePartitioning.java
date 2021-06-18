package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

public class _131PalindromePartitioning {
	public static void main(String[] args) {
		System.out.println(new _131PalindromePartitioning().isPalindrom("ab", 1, 1));
		
		System.out.println(new _131PalindromePartitioning().solve("aab").toString());

	}

	/**
	 * This is same as _46Permutations
	 * 
	 * 
	 * https://www.youtube.com/watch?v=4ykBXGbonlA
	 */
	public List<List<String>> solve(String s) {
		List<List<String>> res = new ArrayList<List<String>>();

		List<String> permutation = new ArrayList<>();
		// string s, buildPointer, permutation, res
		helper(s, 0, permutation, res);

		return res;

	}

	public void helper(String s, int buildPointer, List<String> permutation, List<List<String>> res) {
		if (s.length() == buildPointer) {
			res.add(new ArrayList<>(permutation));
			return;
		} else {
			for (int i = buildPointer; i < s.length(); i++) {
				if (isPalindrom(s, buildPointer, i)) {
					String palindromSnippet = s.substring(buildPointer, i + 1);
					permutation.add(palindromSnippet);
					helper(s, i + 1, permutation, res);
					permutation.remove(permutation.size() - 1);
				}

			}
		}

	}

	public boolean isPalindrom(String s, int low, int high) {
		if (low == high) {
			return true;

		}
		while (low < high) {
			if (s.charAt(low) != s.charAt(high)) {
				return false;

			} else {
				low++;
				high--;
			}

		}
		return true;

	}

}
