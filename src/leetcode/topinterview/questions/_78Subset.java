package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _78Subset {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3 };
		System.out.println(new _78Subset().findSubsets(a).toString());

	}

	/**
	 * https://www.youtube.com/watch?v=LdtQAYdYLcE
	 * 
	 * 
	 * 
	 * For all those who are facing difficulty in understanding the solution, this will definitely save your day.
Let's take an example -> nums = [1,2,3]

first of all, we created current = [ ]
Now, we are going to create a copy of current and add it to our subsets Arraylist.
So far, we have subsets = [[ ]] 

Now, we insert the nums[i] i.e., nums[0] in current. Current become -> [1]
Now, we make a recursion call with index = 1 and current = [1].

Now, we  add current in subsets. Subsets = [[ ], [1]] (created a copy of current and added it to subset)
Add nums[i] to current where index = 1. Current = [1,2]
Recursion call -> index = 2, current = [1, 2].

Add current to subsets. Subsets = [[ ], [1], [1,2]]
Add nums[i] to current where index = 2.
Recursion call -> index = 3, current = [1,2,3]

Add current to subset. Subsets = [[ ], [1],[1,2],[1,2,3]]
Now, for loop won't execute because index > nums.length().
So, it will return now. 

Now, we come to statement current.remove(current.size() - 1).
We now get, current = [1,2]. i = 2 here. Now, we come to next iteration of for loop, i becomes 3 but 3 < nums.length(). 
So, it will again return.

Now, we come to statement current.remove(current.size() - 1) again.
We now get, current = [1], i = 1 here. Now, in next loop iteration, i = 2.
We add nums[i] to current. i = 2. Current = [1,3]
Recursion Call -> current = [1,3], index = 3

Insert current to subset. Subset = [[ ], [1], [1,2], [1,2,3], [1,3]]
We now try to run the loop but i = 3 and it is not less than nums.length(). 
So, we return.

Now, we come back to statement current.remove(current.size() - 1).


And in the same fashion, [1] is also removed. After 1 is removed, we get [ ] and we insert 2 in it. then we insert [2] in subsets. Then we insert [2,3]. Then we remove 3 and 2. Then we insert [3]. And we are done.

We finally get subset = [[ ], [1], [1,2], [1,2,3], [1,3], [2], [2,3], [3]] ------> ANSWER. Return it. 
	 */
	public List<List<Integer>> findSubsets(int a[]) {
		List<List<Integer>> subsets = new ArrayList<>();
		helper(0, a, new ArrayList<Integer>(), subsets);
		return subsets;

	}

	private void helper(int index, int[] a, List<Integer> current, List<List<Integer>> subsets) {
		subsets.add(new ArrayList<>(current)); // add the copy of it
		for (int i = index; i < a.length; i++) {
			// either to add it or not add it
			current.add(a[i]);
			helper(i + 1, a, current, subsets);
			current.remove(current.size() - 1);
		}
	}

//	/**
//	 * get all the substrings of the given string 
//	 * 
//	 * @param a
//	 * @return
//	 */
//	public List<List<Integer>> findSets(int a[]) {
//		List<List<Integer>> res = new ArrayList<>();
//		StringBuilder sb = new StringBuilder();
//		Set<List<Integer>> resSet = new HashSet<>();
//		resSet.add(new ArrayList<Integer>());
//		
//		for (int i = 0; i < a.length; i++) {
//			 sb.append(a[i]);
//		}
//		String s = sb.toString();
//		for (int i = 0; i < s.length(); i++) {
//			for (int j = i + 1; j <= s.length(); j++) {
//				String temp = s.substring(i, j);
//				List<Integer> tt = new ArrayList<>();
//				for (int k = 0; k < temp.length(); k++) {
//					tt.add(temp.charAt(k) - '0');
//				}
//				resSet.add(tt);
//			}
//		}
//		
//		res = new ArrayList<>(resSet);
//		return res;
//
//	}

}
