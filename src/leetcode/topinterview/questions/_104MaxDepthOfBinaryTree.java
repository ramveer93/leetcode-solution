package leetcode.topinterview.questions;

public class _104MaxDepthOfBinaryTree {
	int val;
	_104MaxDepthOfBinaryTree left;
	_104MaxDepthOfBinaryTree right;

	/**
	 * 
	 * 
	 * 
	 * this is also the length of the longest path from root to leaf node
	 * 
	 * 
	 * Height at every level will be max(leftHeight,rightHeight)+1;
	 * 
	 */
	public int maxDepth(_104MaxDepthOfBinaryTree root) {
		if (root == null) {
			return 0;
		}
		int leftMax = maxDepth(root.left);
		int rightMax = maxDepth(root.right);
		return 1 + Math.max(leftMax, rightMax);
	}

}
