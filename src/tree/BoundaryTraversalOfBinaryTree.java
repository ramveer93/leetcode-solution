package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoundaryTraversalOfBinaryTree {

	/**
	 * https://www.youtube.com/watch?v=uemjIijtu2I
	 */
	public List<Integer> boundaryTraversal(TreeNode root) {
		List<Integer> rightView = new RightViewOfBST().rightView(root);
		List<Integer> leftView = new LeftViewOfBST().leftView(root);
		List<Integer> leafNodes = new ArrayList<>();
		getLeafNodes(root, leafNodes);
		Set<Integer> res = new HashSet<>();
		res.addAll(rightView);
		res.addAll(leftView);
		res.addAll(leafNodes);
		return new ArrayList<>(res);

	}

	private void getLeafNodes(TreeNode root, List<Integer> leafNodes) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			leafNodes.add(root.val);
		}
		getLeafNodes(root.left, leafNodes);
		getLeafNodes(root.right, leafNodes);
	}

}
