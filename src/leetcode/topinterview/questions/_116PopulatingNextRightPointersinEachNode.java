package leetcode.topinterview.questions;

import java.util.LinkedList;
import java.util.Queue;

public class _116PopulatingNextRightPointersinEachNode {
	int val;
	_116PopulatingNextRightPointersinEachNode left;
	_116PopulatingNextRightPointersinEachNode right;
	_116PopulatingNextRightPointersinEachNode next;

	_116PopulatingNextRightPointersinEachNode(int val) {
		this.val = val;

	}

	_116PopulatingNextRightPointersinEachNode(int val, _116PopulatingNextRightPointersinEachNode left,
			_116PopulatingNextRightPointersinEachNode right, _116PopulatingNextRightPointersinEachNode next) {
		this.val = val;
		this.left = left;
		this.right = right;
		this.next = next;
	}

	/**
	 * 
	 * Idea is to do the level order traversal, and for every curr node point it to
	 * queue.peek();
	 */
	public _116PopulatingNextRightPointersinEachNode populateNextRightPointer(
			_116PopulatingNextRightPointersinEachNode root) {
		if (root == null)
			return null;
		Queue<_116PopulatingNextRightPointersinEachNode> queue = new LinkedList<>();

		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				_116PopulatingNextRightPointersinEachNode curr = queue.poll();
				if (i < size - 1) { // why this, because we dont want the last node of a level to point to peek of queue, it will point to null
					curr.next = queue.peek();
				}
				if (curr.left != null) {
					queue.add(curr.left);
				}
				if (curr.right != null) {
					queue.add(curr.right);
				}
			}
		}
		return root;

	}

}
