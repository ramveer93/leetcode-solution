package leetcode.topinterview.questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _287FindTheDuplicateNumber {

	public static void main(String[] args) {

		int a[] = { 1, 67, 2, 90, 34, 2, 65 };
		System.out.println(new _287FindTheDuplicateNumber().findDuplicate(a));
		System.out.println(new _287FindTheDuplicateNumber().findDuplicateWithSpace(a));
		
	}

	/**
	 * 1. sort the array and then find the duplicate
	 * 
	 * 2. add elements in hashset , set.containskey(key) == true then duplicate
	 * 
	 */
	public int findDuplicate(int a[]) {
		Arrays.sort(a);
		for (int i = 1; i < a.length; i++) {
			if (a[i] == a[i - 1]) {
				return a[i];

			}

		}
		return -1;

	}

	public int findDuplicateWithSpace(int a[]) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			if (!set.add(a[i])) {
				return a[i];
			}

		}
		return -1;

	}
}
