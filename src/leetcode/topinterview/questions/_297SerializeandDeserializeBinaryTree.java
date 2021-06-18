package leetcode.topinterview.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _297SerializeandDeserializeBinaryTree {

	public static void main(String[] args) {

	}

	/**
	 * https://www.youtube.com/watch?v=suj1ro8TIVY
	 * 
	 * Convert the tree to string with pre order tree traversal
	 * 
	 * VERY IMPORTANT: We have to focus on jus the current node and let the
	 * recursion handle the left and right sub tree problme
	 * 
	 * 
	 */
	public String serialize(TreeNode root) {
		if (root == null) {
			return "X,";
		}
		String leftSubTreeString = serialize(root.left);
		String rightSubTreeString = serialize(root.right);
		return root.val + "," + leftSubTreeString + rightSubTreeString; // pre order traversal
	}
	
	
	/**
	 * Take the string from serialize and make tree out of this
	 * Create a queue out of string 
	 * Here also focus on current node let the recursion figure out left and right sub tree
	 */
	public TreeNode deserialize(String s) {
		Queue<String> queue = new LinkedList<>();
		queue.addAll(Arrays.asList(s.split(",")));
		return helper(queue);
	}

	private TreeNode helper(Queue<String> queue) {
		String nodeValue = queue.poll();
		if (nodeValue.equals("X"))
			return null;
		TreeNode node = new TreeNode(Integer.valueOf(nodeValue));
		node.left = helper(queue);
		node.right = helper(queue);
		return node;

	}
}
