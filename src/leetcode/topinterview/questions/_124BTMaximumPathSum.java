package leetcode.topinterview.questions;

public class _124BTMaximumPathSum {
	int val;
	_124BTMaximumPathSum left;
	_124BTMaximumPathSum right;

	_124BTMaximumPathSum(int val) {
		this.val = val;

	}

	_124BTMaximumPathSum(int val, _124BTMaximumPathSum left, _124BTMaximumPathSum right) {
		this.val = val;
		this.left = left;
		this.right = right;

	}

	int max;

	public int maxPathEfficient(_124BTMaximumPathSum root) {
		max = Integer.MIN_VALUE;
		help(root);
		return max;
	}

	public int help(_124BTMaximumPathSum root) {
		if (root == null)
			return 0;
		int left = Math.max(0, help(root.left));
		int right = Math.max(0, help(root.right));
		max = Math.max(max, left + right + root.val);
		return Math.max(left, right) + root.val;
	}

	/**
	 * this is related to _543, instead of 1 , we do root.value , that is the only
	 * difference
	 * 
	 * @param root
	 * @return
	 */
	public int maxPathSum(_124BTMaximumPathSum root) {

		return helper(root);
	}

	public int helper(_124BTMaximumPathSum root) {
		if (root == null)
			return 0;
		int left_height = Math.max(0, height(root.left));
		int right_height = Math.max(0, height(root.right));
		int leftPath = Math.max(0, helper(root.left));
		int rightPath = Math.max(0, helper(root.right));
		int maxPath = Math.max(left_height + right_height + root.val, Math.max(leftPath, rightPath));
		return maxPath;
	}

	private int height(_124BTMaximumPathSum root) {
		if (root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		if (left > right) {
			return root.val + left;

		} else
			return root.val + right;
	}

}
