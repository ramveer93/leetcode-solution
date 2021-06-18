package adityaverma.dp.dpOnTree;

public class MaxPathSumFromLeafToLeaf {

	int ans;

	public int maxPath(TreeNode root) {
		if (root == null)
			return 0;
		solve(root);
		return ans;
	}

	private int solve(TreeNode root) {
		if (root == null)
			return 0;
		int left = Math.max(0, solve(root.left));
		int right = Math.max(0, solve(root.right));
		int temp = Math.max(left, right) + root.val;
		if (root.left == null && root.right == null) {
			temp = Math.max(temp, root.val);
		}
		ans = Math.max(ans, left + right + root.val);
		return temp;

	}
}
