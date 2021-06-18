package tree;

import java.util.ArrayList;
import java.util.List;

public class TraversalInorderPreorderPostOrder {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		List<Integer> res = new ArrayList<>();
		new TraversalInorderPreorderPostOrder().inorder(root, res);
		System.out.println(res.toString());

	}

	public void inorder(TreeNode root, List<Integer> res) {
		// L rt R
		if (root != null) {
			inorder(root.left, res);
		}
		res.add(root.val);
		if (root.right != null) {
			inorder(root.right, res);

		}
	}

	public void preorder(TreeNode root, List<Integer> res) {
		// rt L R
		if (root != null) {
			res.add(root.val);
			if (root.left != null) {
				preorder(root.left, res);
			}
			if (root.right != null) {
				preorder(root.right, res);
			}

		}

	}

	public void postorder(TreeNode root, List<Integer> res) {
		if (root != null) {
			if (root.left != null) {
				postorder(root.left, res);

			}
			if (root.right != null) {
				postorder(root.right, res);

			}
			res.add(root.val);

		}

	}

}
