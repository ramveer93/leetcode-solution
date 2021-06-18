package adityaverma.dp.dpOnTree;

public class DiameterOfBinaryTree {

	public static void main(String[] args) {

		System.out.println(new DiameterOfBinaryTree().diameter(new TreeNode(1)));

	}

	int ans;

	public int diameter(TreeNode root) {
		if (root == null)
			return 0;
		solve(root);
		return ans;

	}

	public int solve(TreeNode root) {
		// base condition
		if (root == null)
			return 0;
		// hypothesis
		int left = solve(root.left);
		int right = solve(root.right);

		// indection-> means for the current node
		int temp = Math.max(left, right) + 1;// when it doesnt want to become ans
		ans = Math.max(ans, left + right + 1);//when it wants to become ans
		return temp;

	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;

	}
}
