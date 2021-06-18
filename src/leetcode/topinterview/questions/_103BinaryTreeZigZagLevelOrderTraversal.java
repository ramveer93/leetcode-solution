package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _103BinaryTreeZigZagLevelOrderTraversal {
	int val;
	_103BinaryTreeZigZagLevelOrderTraversal left;
	_103BinaryTreeZigZagLevelOrderTraversal right;

	_103BinaryTreeZigZagLevelOrderTraversal(int val) {
		this.val = val;

	}

	_103BinaryTreeZigZagLevelOrderTraversal(int val, _103BinaryTreeZigZagLevelOrderTraversal left,
			_103BinaryTreeZigZagLevelOrderTraversal right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	/**
	 * https://www.youtube.com/watch?v=vjt5Y6-1KsQ
	 * 
	 * use two stacks,
	 */
	@SuppressWarnings("unused")
	public List<List<Integer>> binaryTreeZigZagLevelOrder(_103BinaryTreeZigZagLevelOrderTraversal root) {

		List<List<Integer>> res = new ArrayList<>();

		Stack<_103BinaryTreeZigZagLevelOrderTraversal> current = new Stack<>();
		Stack<_103BinaryTreeZigZagLevelOrderTraversal> next = new Stack<>();

		List<Integer> partialResult = new ArrayList<>();
		boolean leftToRight = true;

		if (root != null) {
			current.add(root);

		}

		while (!current.isEmpty()) {
			_103BinaryTreeZigZagLevelOrderTraversal node = current.pop();
			partialResult.add(node.val);
			
			if (leftToRight) {
				if (node.left != null) {
					next.push(node.left);

				}
				if (node.right != null) {
					next.push(node.right);

				}

			} else {
				if (node.right != null) {
					next.push(node.right);

				}
				if (node.left != null) {
					next.push(node.left);

				}
			}
			if (current.isEmpty()) { // swap the stacks
				leftToRight = !leftToRight;
				Stack<_103BinaryTreeZigZagLevelOrderTraversal> temp = current;
				current = next;
				next = temp;
				res.add(partialResult);
				partialResult = new ArrayList<>();
			}

		}
		return res;

	}

}
