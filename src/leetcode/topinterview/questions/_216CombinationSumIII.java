package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Find all valid combinations of k numbers that sum up to n such that the
 * following conditions are true:
 * 
 * Only numbers 1 through 9 are used. Each number is used at most once. Return a
 * list of all possible valid combinations. The list must not contain the same
 * combination twice, and the combinations may be returned in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: k = 3, n = 7 Output: [[1,2,4]] Explanation: 1 + 2 + 4 = 7 There are no
 * other valid combinations. Example 2:
 * 
 * Input: k = 3, n = 9 Output: [[1,2,6],[1,3,5],[2,3,4]] Explanation: 1 + 2 + 6
 * = 9 1 + 3 + 5 = 9 2 + 3 + 4 = 9 There are no other valid combinations.
 * 
 *
 */
public class _216CombinationSumIII {

	public static void main(String[] args) {

		System.out.println(new _216CombinationSumIII().combinationSum3(3, 9));
	}

	public List<List<Integer>> combinationSum3(int k, int n) {

		List<List<Integer>> res = new ArrayList<>();
		helper(res, k, n, 1, new ArrayList<>());
		return res;
	}

	/**
	 * https://leetcode.com/problems/combination-sum-ii/discuss/16878/Combination-Sum-I-II-and-III-Java-solution-(see-the-similarities-yourself)
	 * 
	 */
	public void helper(List<List<Integer>> res, int k, int target, int start, List<Integer> perm) {

		if (perm.size() > k) {
			return;
		}
		if (perm.size() == k && target == 0) {
			res.add(new ArrayList<>(perm));
			return;
		} else {
			for (int i = start; i <= 9; i++) {
				perm.add(i);
				helper(res, k, target - i, i + 1, perm);
				perm.remove(perm.size() - 1);

			}
		}
	}

}
