package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sramveer
 *
 *         Given an array of integers where 1<=a[i]<=n(n size of array ), Some
 *         elements appear twice and other appear once. Find all the elements of
 *         [1,n] that dont appear in the array
 *
 *         Could you do it without extra space and o(n) time
 *
 *         e.g: [4,3,2,7,8,2,3,1] ans: [5,6]
 */
public class _163MissingRanges {

	public static void main(String[] args) {
		int a[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(new _163MissingRanges().findDisappearedNumbersfficient(a).toString());
	}

	/**
	 * We can add all the numbers to set and then check one by one if the no exits
	 * in set
	 */
	public List<Integer> anotherApproach(int a[]) {
		List<Integer> res = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
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

	public List<Integer> findDisappearedNumbersfficient(int a[]) {
		int res[] = new int[a.length + 1];
		List<Integer> temp = new ArrayList<>();

		Arrays.fill(res, 0);

		for (int i : a) {
			res[i] = 1;
		}

		for (int i = 1; i < res.length; i++) {
			if (res[i] == 0)
				temp.add(i);
		}
		return temp;

	}

	/**
	 * Idea is to traverse the whole array from start = 1 to length , check for
	 * every element if it exists in array
	 */
	public List<Integer> findDisappearedNumbers(int a[]) {
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i <= a.length; i++) {
			if (!isNumberExistsInArray(a, i)) {
				res.add(i);
			}
		}
		return res;
	}

	public boolean isNumberExistsInArray(int a[], int x) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x)
				return true;

		}
		return false;

	}

}
