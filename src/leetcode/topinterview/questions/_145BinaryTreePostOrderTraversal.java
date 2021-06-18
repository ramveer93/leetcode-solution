package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

public class _145BinaryTreePostOrderTraversal {
	_145BinaryTreePostOrderTraversal left;
	_145BinaryTreePostOrderTraversal right;
	int val;

	public List<Integer> postOrderTraversal(_145BinaryTreePostOrderTraversal root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;
	}

	public void helper(_145BinaryTreePostOrderTraversal root, List<Integer> res) {
		if (root != null) {
			if (root.left != null) {
				helper(root.left, res);
			}
			if (root.right != null) {
				helper(root.right, res);
			}
			res.add(root.val);
		}
	}
}
