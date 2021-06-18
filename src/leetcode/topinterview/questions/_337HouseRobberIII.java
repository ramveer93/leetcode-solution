package leetcode.topinterview.questions;

import java.util.HashMap;
import java.util.Map;

public class _337HouseRobberIII {

	Map<TreeNode, Integer> robResult = new HashMap<>();// when parentRobbed is true
	Map<TreeNode, Integer> notRobResult = new HashMap<>(); // when parentRobbed is false

	public static void main(String[] args) {

	}

	public int rob(TreeNode root) {
		// root is current node
		// false is whether parents robbed or not
		return helper(root, false);

	}

	/**
	 * https://leetcode.com/problems/house-robber-iii/solution/
	 * 
	 * So two cases:
	 * 1. When the parents are robbed: we dont have any choice but not to rob the child
	 * 2. when parents are not robbed: 
	 *    case 1:-> We can rob the curr node 
	 *    case 2:-> we can't rob the curr node 
	 *We will take the max of both 
	 *
	 */
	public int helper(TreeNode node, boolean parentRobbed) {
		if (node == null)
			return 0;
		if (parentRobbed) {
			// we can't have to rob its childs, so just one choice, we cant rob
			if (robResult.containsKey(node))
				return robResult.get(node);
			int result = helper(node.left, false) + helper(node.right, false);
			robResult.put(node, result);
			return result;

		} else {
			// 2 choices, either we rob the curr node or not rob the curr not , we take max
			// of both
			if (notRobResult.containsKey(node))
				return notRobResult.get(node);
			int rob = node.val + helper(node.left, true) + helper(node.right, true);
			int notRob = helper(node.left, false) + helper(node.right, false);
			int result = Math.max(rob, notRob);
			notRobResult.put(node, result);
			return result;
		}

	}
}
