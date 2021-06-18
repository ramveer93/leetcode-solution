package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94BinaryTreeInorderTraversal {
	int val;
	_94BinaryTreeInorderTraversal left;
	_94BinaryTreeInorderTraversal right;

	_94BinaryTreeInorderTraversal() {
	};

	_94BinaryTreeInorderTraversal(int val, _94BinaryTreeInorderTraversal left, _94BinaryTreeInorderTraversal right) {
		this.val = val;
		this.left = left;
		this.right = right;

	}

	/**
	 * iterative
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorder(_94BinaryTreeInorderTraversal root) {
		_94BinaryTreeInorderTraversal curr = root;
		Stack<_94BinaryTreeInorderTraversal> stack = new Stack<>();
		List<Integer> res = new ArrayList<>();

		while (curr != null || !stack.isEmpty()) {
			// first push all lefts of curr to stack
			while (curr != null) {
				stack.add(curr);
				curr = curr.left;

			}
			// now curr.left is null so start poping from stack add it to list
			curr = stack.pop();

			res.add(curr.val);

			curr = curr.right;

		}
		return res;

	}

	/**
	 * recursive
	 */
	public List<Integer> inorderRec(_94BinaryTreeInorderTraversal root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);

		return res;
	}

	public void helper(_94BinaryTreeInorderTraversal root, List<Integer> res) {
		if (root != null) {
			if (root.left != null) {
				helper(root.left, res);
			}
			res.add(root.val);
			if (root.right != null) {
				helper(root.right, res);

			}

		}

	}

}
