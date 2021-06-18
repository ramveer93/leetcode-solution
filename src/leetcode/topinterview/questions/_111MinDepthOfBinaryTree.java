package leetcode.topinterview.questions;

import java.util.LinkedList;
import java.util.Queue;

public class _111MinDepthOfBinaryTree {
	int val;
	_111MinDepthOfBinaryTree left;
	_111MinDepthOfBinaryTree right;

	_111MinDepthOfBinaryTree(int val, _111MinDepthOfBinaryTree left, _111MinDepthOfBinaryTree right) {
		this.val = val;
		this.left = left;
		this.right = right;

	}

	/**
	 * 
	 * this is also the min sorted path length find the leaf node
	 */
	public int minDepthRecursive(_111MinDepthOfBinaryTree root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1; // that means this is a leaf node
		}
		if (root.left == null) {
			return minDepthRecursive(root.right) + 1;
		}
		if (root.right == null) {
			return minDepthRecursive(root.left);
		}
		return 1 + Math.min(minDepthRecursive(root.left), minDepthRecursive(root.right));
	}

	/**
	 * https://www.youtube.com/playlist?list=PLko32sysgiEPGS4bXBRyZMo9ztcHmPI1z
	 * 
	 * we will use same approach as to do the level order traversal basically it
	 * will be BFS, so we will use queue
	 */
	public int minDepth(_111MinDepthOfBinaryTree root) {
		if (root == null) {
			return 0;

		}
		Queue<_111MinDepthOfBinaryTree> queue = new LinkedList<>();
		int depth = 0;

		queue.add(root);

		while (!queue.isEmpty()) {
			int noOfNodes = queue.size();
			for (int i = 0; i < noOfNodes; i++) {
				_111MinDepthOfBinaryTree curr = queue.remove();
				if (curr.left == null && curr.right == null) // if curr node is leaf node
				{
					depth++;
					return depth;

				}
				if (curr.left != null) {
					queue.add(curr.left);

				}
				if (curr.right != null) {
					queue.add(curr.right);

				}
			}
			depth++; // if you have to do anything with the level , then this is the place 

		}

		return depth;

	}

}
