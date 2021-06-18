package leetcode.topinterview.questions;

import java.util.LinkedList;
import java.util.Queue;

public class _226InvertABinaryTree {

	public static void main(String[] args) {

	}

	/**
	 * https://www.youtube.com/watch?v=_i0jqdVkObU
	 * 
	 * we just have to swap curr node's left and right child its same as we swap the
	 * two variables
	 * 
	 */
	public TreeNode invertBT(TreeNode root) {
		if (root == null)
			return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			/**
			 * 
			 * now swap left and right child even if they are null
			 */
			TreeNode temp = curr.left;
			curr.left = curr.right;
			curr.right = temp;
			if (curr.left != null)
				queue.add(curr.left);
			if (curr.right != null)
				queue.add(curr.right);

		}
		return root;
	}
}
