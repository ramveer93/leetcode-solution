package adityaverma.dp.dpOnTree;

public class MaxPathSumFromAnyNodeToAnyNodeInBinaryTree {

	int ans;
	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		ans = Integer.MIN_VALUE;
		solve(root);
		return ans;
	}

	private int solve(TreeNode root) {
		if (root == null)
			return 0;
		int left = Math.max(0, solve(root.left));
		int right = Math.max(0, solve(root.right));
		int temp = Math.max(Math.max(left, right) + root.val, root.val);
		ans = Math.max(left + right + root.val, ans);
		return temp;
	}
}
