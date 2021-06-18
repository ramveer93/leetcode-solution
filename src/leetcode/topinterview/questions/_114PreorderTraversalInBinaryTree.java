package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

public class _114PreorderTraversalInBinaryTree {
	int val;
	_114PreorderTraversalInBinaryTree left;
	_114PreorderTraversalInBinaryTree right;

	_114PreorderTraversalInBinaryTree(int val, _114PreorderTraversalInBinaryTree left,
			_114PreorderTraversalInBinaryTree right) {
		this.val = val;
		this.left = left;
		this.right = right;

	}

	public List<Integer> preorder(_114PreorderTraversalInBinaryTree root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;

	}

	public void helper(_114PreorderTraversalInBinaryTree root, List<Integer> res) {
		if (root != null) {
			res.add(root.val);
			if (root.left != null) {
				helper(root.left, res);

			}
			if (root.right != null) {
				helper(root.right, res);

			}

		}

	}

}
