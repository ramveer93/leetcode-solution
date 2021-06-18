package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagTreeTraversal {

	public void zigZagTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> next = new Stack<>();
		Stack<TreeNode> current = new Stack<>();
		boolean isleftRight = true;
		if (root == null)
			return;
		current.add(root);
		
		while (!current.isEmpty()) {
			TreeNode curr = current.pop();
			System.out.println(curr.val);
			if (isleftRight) {
				if (curr.left != null) {
					next.add(curr.left);
				}
				if (curr.right != null) {
					next.add(curr.right);
				}
			} else {
				if (curr.right != null) {
					next.add(curr.right);
				}
				if (curr.left != null) {
					next.add(curr.left);
				}
			}
			if (current.isEmpty()) {
				isleftRight = !isleftRight;
				Stack<TreeNode> temp = current;
				current = next;
				next = temp;
			}
		}
	}
}
