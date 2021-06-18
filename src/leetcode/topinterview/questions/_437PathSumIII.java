package leetcode.topinterview.questions;

import java.util.HashMap;
import java.util.Map;

public class _437PathSumIII {

	int result = 0;

	/**
	 * 
	 * https://www.youtube.com/watch?v=yyZA4v0x16w
	 * 
	 * First see _560 , same approach is being used here also
	 * 
	 * Find all the paths which has sum equal to k , doesnt necessary starts with
	 * root and end with leaf
	 */
	public int pathSum(TreeNode root, int k) {
		if (root == null)
			return 0;
		Map<Integer, Integer> cumulativeSum = new HashMap<>();
		cumulativeSum.put(0, 1);
		helper(root, k, 0, cumulativeSum);
		return result;

	}

	public void helper(TreeNode root, int k, int sum, Map<Integer, Integer> map) {
		if (root == null)
			return;
		sum += root.val;
		if (map.containsKey(sum - k)) {
			result += map.get(sum - k);
		}
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		helper(root.left, k, sum, map);
		helper(root.right, k, sum, map);
		map.put(sum, map.get(sum) - 1);
		return;
	}

}
