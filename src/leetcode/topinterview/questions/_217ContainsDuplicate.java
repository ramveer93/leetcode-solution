package leetcode.topinterview.questions;

import java.util.HashSet;
import java.util.Set;

public class _217ContainsDuplicate {

	public static void main(String[] args) 
	{
		
		int a[] = {1,1,1,3,3,4,3,2,4,2};
		System.out.println(new _217ContainsDuplicate().duplicates(a));
		
	}

	/**
	 * Method1: O(n*2), two loops method 2: sorting and then a[i] == a[i+1] true
	 * method 3: set/map
	 * 
	 * @return
	 */
	public boolean duplicates(int a[]) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			if (set.contains(a[i]))
				return true;
			set.add(a[i]);

		}
		return false;

	}

}
