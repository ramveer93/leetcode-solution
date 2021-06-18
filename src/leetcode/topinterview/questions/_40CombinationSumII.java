package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40CombinationSumII {

	public static void main(String[] args) {

		int a[] = {2,5,2,1,2};
		System.out.println(new _40CombinationSumII().combinationSum2(a, 5).toString());
	}

	/**
	 * https://leetcode.com/problems/combination-sum-ii/discuss/16878/Combination-Sum-I-II-and-III-Java-solution-(see-the-similarities-yourself)
	 * 
	 * here we need to print all the combinations of the given number but any no can be taken only once
	 */
	public List<List<Integer>> combinationSum2(int a[], int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (a.length == 0)
			return res;
		Arrays.sort(a);
		helper(res, new ArrayList<>(), 0, target, a);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> perm, int start, int target, int a[]) {
		if (target < 0)
			return;
		if (target == 0) {
			res.add(new ArrayList<>(perm));
			return;
		} else {
			for (int i = start; i < a.length; i++) {
				if (i > start && a[i] == a[i - 1])
					continue;
				perm.add(a[i]);
				helper(res, perm, i + 1, target - a[i], a);
				perm.remove(perm.size() - 1);

			}
		}

	}
}
