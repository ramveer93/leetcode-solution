package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _589NaryTreePreorderTraversal {

	List<Integer> res = new ArrayList<>();
	int val;
	public List<_589NaryTreePreorderTraversal> children;

	_589NaryTreePreorderTraversal() {
	};

	_589NaryTreePreorderTraversal(int val, List<_589NaryTreePreorderTraversal> children) {
		this.val = val;
		this.children = children;

	}

	/**
	 * recursion
	 */
	public List<Integer> preorder(_589NaryTreePreorderTraversal root) {
		if (root == null)
			return null;
		res.add(root.val);

		for (_589NaryTreePreorderTraversal node : root.children) {
			preorder(node);

		}
		return res;
	}

	/**
	 * iterative
	 */
	public List<Integer> iterative(_589NaryTreePreorderTraversal root) {
		if (root == null)
			return res;
		Stack<_589NaryTreePreorderTraversal> stack = new Stack<>();
		stack.add(root);

		while (!stack.isEmpty()) {
			_589NaryTreePreorderTraversal curr = stack.pop();
			res.add(curr.val);

			for (int i = curr.children.size() - 1; i >= 0; i--) {
				stack.add(curr.children.get(i));

			}

		}
		return res;

	}

}
