package leetcode.topinterview.questions;

public class _101SymmetricTree {
	int val;
	_101SymmetricTree left;
	_101SymmetricTree right;

	_101SymmetricTree(int val, _101SymmetricTree left, _101SymmetricTree right) {
		this.val = val;
		this.left = left;
		this.right = right;

	}

	public boolean isSymmetric(_101SymmetricTree root) {
		if (root == null)
			return true;
		return helper(root.left, root.right);

	}

	/**
	 * 
	 * WATCH THIS FIRST :
	 * 
	 * https://www.youtube.com/watch?v=XV7Sg2hJO3Q
	 */
	public boolean helper(_101SymmetricTree p, _101SymmetricTree q) {
		if (p == null || q == null) {
			if (p == q) {
				return true;

			} else {
				return false;
			}

		}
		if (p.val != q.val) { // left of p is not equal to right of q
			return false;

		}
		return helper(p.left, q.right) && helper(p.right, q.left);

	}

}
