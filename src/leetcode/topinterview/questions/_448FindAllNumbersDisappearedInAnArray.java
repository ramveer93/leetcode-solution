package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 * 
 * Example:
 * 
 * Input: [4,3,2,7,8,2,3,1]
 * 
 * Output: [5,6]
 * 
 * @author sramveer
 *
 */

public class _448FindAllNumbersDisappearedInAnArray {

	public static void main(String[] args) {

		int a[] = {4,3,2,7,8,2,3,1};
		System.out.println(new _448FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(a).toString());
	}

	public List<Integer> findDisappearedNumbers(int a[]) {
		Set<Integer> set = new HashSet<>();

		List<Integer> res = new ArrayList<>();
		if(a.length==0)return res;
		
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}

		for (int i = 1; i <= a.length; i++) {
			if (!set.contains(i)) {
				res.add(i);
			}

		}
		return res;

	}

}
