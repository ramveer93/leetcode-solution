package leetcode.topinterview.questions;

import java.util.HashSet;
import java.util.Set;

public class FindMissionPositive41 {
	public static void main(String[] args) {

	}

	/**
	 * idea is to 1. put all the elements in set 2.find max from elements 3. loop
	 * from 1 to max search in set
	 * 
	 * @param a
	 * @return
	 */
	public int findMissingPositive(int a[]) {
		int max = 0;
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
			if (max < a[i]) {
				max = a[i];
			}
		}

		for (int i = 1; i < max; i++) {
			if (!set.contains(i)) {
				return i;

			}

		}
		return max + 1;

	}

}
