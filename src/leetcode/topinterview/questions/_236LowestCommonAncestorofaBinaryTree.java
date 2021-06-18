package leetcode.topinterview.questions;

public class _236LowestCommonAncestorofaBinaryTree {
	int val;
	_236LowestCommonAncestorofaBinaryTree left;
	_236LowestCommonAncestorofaBinaryTree right;

	_236LowestCommonAncestorofaBinaryTree(int val) {
		this.val = val;
	}

	_236LowestCommonAncestorofaBinaryTree(int val, _236LowestCommonAncestorofaBinaryTree left,
			_236LowestCommonAncestorofaBinaryTree right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	/**
	 * https://www.youtube.com/watch?v=13m9ZCB8gjw
	 * 
	 * 1st method is find the path from root to p1 and root to p2 and return the
	 * last repeating node in path method 2: recursion
	 *
	 * 
	 */
	public _236LowestCommonAncestorofaBinaryTree lcaBT(_236LowestCommonAncestorofaBinaryTree root,
			_236LowestCommonAncestorofaBinaryTree p1, _236LowestCommonAncestorofaBinaryTree p2) {
		if (root == null)
			return root;
		if (root == p1 || root == p2)
			return root;
		_236LowestCommonAncestorofaBinaryTree left = lcaBT(root.left, p1, p2);
		_236LowestCommonAncestorofaBinaryTree right = lcaBT(root.right, p1, p2);
		if (left != null && right != null)
			return root;
		if (left == null && right == null)
			return null;
		return left == null ? right : left;

	}

}
