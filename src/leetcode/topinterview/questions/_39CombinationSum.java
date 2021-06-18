package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39CombinationSum {

	public static void main(String[] args) {

		int candidates[] = { 2, 3, 6, 7 };
		System.out.println(new _39CombinationSum().combinationSum(candidates, 7).toString());
	}

	/**
	 * https://www.youtube.com/watch?v=irFtGMLbf-s
	 * 
	 */
	public List<List<Integer>> combinationSum(int candidates[], int target) {

		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0)
			return res;
		List<Integer> perm = new ArrayList<>();
		Arrays.sort(candidates);
		helper(candidates, res, perm, 0, target);
		return res;
	}

	private void helper(int candidates[], List<List<Integer>> res, List<Integer> perm, int startIndex, int target) {
		if (target == 0) {
			res.add(new ArrayList<>(perm));
			return;
		}
		for (int i = startIndex; i < candidates.length; i++) {
			if (candidates[i] > target) {
				break;
			}
			perm.add(candidates[i]);
			helper(candidates, res, perm, i, target - candidates[i]);
			perm.remove(perm.size() - 1);

		}

	}
}
