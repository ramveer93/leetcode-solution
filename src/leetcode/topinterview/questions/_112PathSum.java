package leetcode.topinterview.questions;

import java.util.Stack;

public class _112PathSum {

	/**
	 * https://www.youtube.com/watch?v=nBbYMdtZIuc
	 * 
	 * in a tree find if a path with sum exist or not
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		Stack<TreeNode> nodeStack = new Stack<>();
		Stack<Integer> pathStack = new Stack<>();
		nodeStack.add(root);
		pathStack.add(sum - root.val);
		while (!nodeStack.isEmpty()) {
			TreeNode curr = nodeStack.pop();
			int currPathSum = pathStack.pop();
			if (curr.left == null && curr.right == null && currPathSum == 0)
				return true;
			if (curr.left != null) {
				nodeStack.add(curr.left);
				pathStack.add(currPathSum - curr.left.val);
			}
			if (curr.right != null) {
				nodeStack.add(curr.right);
				pathStack.add(currPathSum - curr.right.val);
			}
		}
		return false;
	}
}
