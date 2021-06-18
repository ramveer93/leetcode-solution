package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102BinaryTreeLevelOrderTraversal {
	int val;
	_102BinaryTreeLevelOrderTraversal left;
	_102BinaryTreeLevelOrderTraversal right;

	_102BinaryTreeLevelOrderTraversal(int val, _102BinaryTreeLevelOrderTraversal left,
			_102BinaryTreeLevelOrderTraversal right) {
		this.val = val;
		this.left = left;
		this.right = right;

	}

	/**
	 * https://www.youtube.com/watch?v=gcR28Hc2TNQ
	 * 
	 * for BFS we use queue and for depth first search we use stack
	 * 
	 * 
	 */
	public List<List<Integer>> levelOrderTraversal(_102BinaryTreeLevelOrderTraversal root) {
		Queue<_102BinaryTreeLevelOrderTraversal> queue = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				_102BinaryTreeLevelOrderTraversal curr = queue.remove();
				temp.add(curr.val);
				if (curr.left != null) {
					queue.add(curr.left);

				}
				if (curr.right != null) {
					queue.add(curr.right);

				}

			}

			res.add(temp);

		}
		return res;

	}

}
