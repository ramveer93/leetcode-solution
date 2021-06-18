package leetcode.topinterview.questions;

public class _98ValidateBST {

	int val;
	_98ValidateBST left;
	_98ValidateBST right;

	_98ValidateBST(int val, _98ValidateBST left, _98ValidateBST right) {
		this.val = val;
		this.left = left;
		this.right = right;
	};

	public boolean isBST_98Validate(_98ValidateBST root) {
		helper(root, Long.MIN_VALUE, Long.MAX_VALUE);

		return false;
	}

	public boolean helper(_98ValidateBST root, long min, long max) {
		if (root == null) // single node is also a BST
			return true;
		if (root.val > min && root.val < max) {
			return helper(root.left, min, root.val) && helper(root.right, root.val, max); //max value in left sub tree and min value in right subtree
		} else {
			return false;
		}

	}

}
