package leetcode.topinterview.questions;

public class _543DiameterOfBinaryTree {
	int val;
	_543DiameterOfBinaryTree left;
	_543DiameterOfBinaryTree right;

	_543DiameterOfBinaryTree(int val) {
		this.val = val;

	}

	_543DiameterOfBinaryTree(int val, _543DiameterOfBinaryTree left, _543DiameterOfBinaryTree right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	int diam;

	public int diamEfficient(_543DiameterOfBinaryTree root) {
		diam = 1;
		help(root);
		return diam - 1;

	}

	public int help(_543DiameterOfBinaryTree root) {
		if (root == null)
			return 0;
		int left = help(root.left);
		int right = help(root.right);
		diam = Math.max(diam, left + right + 1);
		return Math.max(left, right) + 1;

	}

	/**
	 * https://www.youtube.com/watch?v=ey7DYc9OANo
	 * 
	 * https://www.youtube.com/watch?v=mWyhPJ1Ukvw
	 * 
	 * this will be the max of three things 1. diameter of left subtree , where it
	 * doesn't include root
	 *  2. diameter of right subtree ,where it doesn't include
	 * root 
	 * 3. deepest node in left subtree including root + deepest node in right
	 * subtree
	 * 
	 * diameter = max(all these three);
	 * 
	 */
	public int diameterOfBT(_543DiameterOfBinaryTree root) {
		if (root == null)
			return 0;
		return helper(root) - 1; // -1 to fit it as per solution

	}

	public int helper(_543DiameterOfBinaryTree root) {
		if (root == null)
			return 0;
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		int lDiameter = helper(root.left);
		int rDiameter = helper(root.right);
		int fd = Math.max(lHeight + rHeight + 1, Math.max(lDiameter, rDiameter));
		return fd;
	}

	/**
	 * https://www.youtube.com/watch?v=_O-mK2g_jhI
	 */

	public int height(_543DiameterOfBinaryTree root) {
		if (root == null) {
			return 0;

		}
		int left = height(root.left);
		int right = height(root.right);
		if (left > right) {
			return 1 + left;

		} else {
			return 1 + right;
		}

	}

}
