package leetcode.topinterview.questions;

public class _106BinaryTreeFromInorderAndPostOrder {

	int val;
	_106BinaryTreeFromInorderAndPostOrder left;
	_106BinaryTreeFromInorderAndPostOrder right;

	_106BinaryTreeFromInorderAndPostOrder(int val) {
		this.val = val;

	}

	_106BinaryTreeFromInorderAndPostOrder(int val, _106BinaryTreeFromInorderAndPostOrder left,
			_106BinaryTreeFromInorderAndPostOrder right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	/**
	 * 
	 * same as _105ConstructBinaryTreeFromPreOrderAndInorder the root will be in
	 * post[] , last element of this array will be root
	 * 
	 */
	public _106BinaryTreeFromInorderAndPostOrder buildTreeFromInAndPost(int[] in, int[] post) {
		// postEnd,inStart, inEnd, in , post
		return helper(post.length - 1, 0, in.length - 1, in, post);

	}

	public _106BinaryTreeFromInorderAndPostOrder helper(int postEnd, int inStart, int inEnd, int[] in, int[] post) {
		// boundary check
		if (postEnd < 0 || inStart > inEnd) {
			return null;
		}
		// construct root node
		_106BinaryTreeFromInorderAndPostOrder root = new _106BinaryTreeFromInorderAndPostOrder(post[postEnd]);
		// now figure out left and right sub tree
		int inIndex = 0;
		for (int i = 0; i < in.length; i++) {
			if (root.val == in[i]) {
				inIndex = i;
				break;

			}

		}
		root.right = helper(postEnd - 1, inIndex + 1, inEnd, in, post);
		root.left = helper(postEnd - (inEnd - inIndex) - 1, inStart, inEnd - 1, in, post);

		return root;

	}

}
