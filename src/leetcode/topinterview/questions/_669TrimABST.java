package leetcode.topinterview.questions;

public class _669TrimABST {

	/**
	 * https://www.youtube.com/watch?v=f7aP--tsTuw
	 * 
	 * 1. if root val <low go to right sub tree 2. root val>high go to left sub tree
	 * 3. else root value is in the range of low and high so set root.left =
	 * trimBST(root.left) and root.right = trimBST(root.rights);
	 */
	public TreeNode trimBST(TreeNode root, int low, int high) {
		if (root == null)
			return null;
		if (root.val < low) {
			trimBST(root.right, low, high);
		}
		if (root.val > high) {
			trimBST(root.left, low, high);

		}
		root.left = trimBST(root.left, low, high);
		root.right = trimBST(root.right, low, high);
		return root;

	}
}
