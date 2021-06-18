package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

public class _46Permutations {
	public static void main(String[] args) 
	{
		int a[] = {1,2,3};
		System.out.println(new _46Permutations().permute(a).toString());
	}

	/**
	 * 1st watch this :
	 * 
	 * https://www.youtube.com/watch?v=idmgLLNIC2U
	 * 
	 * 
	 * https://www.youtube.com/watch?v=nYFd7VHKyWQ&t=6s
	 * 
	 * [1,2,3]
	 * 
	 * idea: 1+permutation(2,3), 2+permutation(1,3) etc.
	 *  time O(n!) 
	 *  space O(n) where
	 * n is length of input array
	 * 
	 */
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		boolean[] used = new boolean[nums.length]; // to store if we have combinations starting from this no
		List<Integer> permutations = new ArrayList<>();
		helper(nums, permutations, used, res);
		return res;
	}

	
	private void helper(int[] nums, List<Integer> permutations, boolean[] used, List<List<Integer>> res) {
		if (nums.length == permutations.size()) {
			res.add(new ArrayList<>(permutations));
			return; // this means we are not returning from method but to call next recursion

		}
		for (int i = 0; i < nums.length; i++) {
			//if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue; //in case of duplicates in input
			if (used[i]) {
				continue;

			}
			used[i] = true; // now we are processing this number so put used[i] to true
			permutations.add(nums[i]);
			helper(nums, permutations, used, res);

			permutations.remove(permutations.size() - 1);
			used[i] = false;

		}

	}

}
