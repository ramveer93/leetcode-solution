package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

public class _113PathSumII {

	public static void main(String[] args) {

	}

	/**
	 * https://www.youtube.com/watch?v=3B5gnrwRmOA
	 * 
	 * Find all the paths from root to leave which sums to sum 
	 * 
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		helper(root, res, new ArrayList<>(), sum);
		return res;
	}

	public void helper(TreeNode root, List<List<Integer>> res, List<Integer> path, int sum) {
		if (root == null)
			return;
		path.add(root.val);
		if (root.val == sum && root.left == null && root.right == null) {
			res.add(new ArrayList<>(path));
			return;
		}
		helper(root.left, res, new ArrayList<>(path), sum - root.val);
		helper(root.right, res, new ArrayList<>(path), sum - root.val);
	}
}
