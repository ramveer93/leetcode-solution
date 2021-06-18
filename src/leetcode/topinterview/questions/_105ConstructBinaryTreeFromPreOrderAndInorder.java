package leetcode.topinterview.questions;

public class _105ConstructBinaryTreeFromPreOrderAndInorder {

	int val;
	_105ConstructBinaryTreeFromPreOrderAndInorder left;
	_105ConstructBinaryTreeFromPreOrderAndInorder right;
	
	_105ConstructBinaryTreeFromPreOrderAndInorder(int val)
	{
		this.val = val;
		
	}

	_105ConstructBinaryTreeFromPreOrderAndInorder(int val, _105ConstructBinaryTreeFromPreOrderAndInorder left,
			_105ConstructBinaryTreeFromPreOrderAndInorder right) {

		this.val = val;
		this.left = left;
		this.right = right;
	}

	/**
	 * https://www.youtube.com/watch?v=PoBGyrIWisE&t=1s  to understand the algorithm
	 * https://www.youtube.com/watch?v=GeltTz3Z1rw to understand the code
	 * 
	 * Idea is to find the root first from preorder array now to find the left and
	 * right sub tree , check inorder array now once we have left and right sub tree
	 * , find the root out of left subtree, for that search the preorder array to
	 * see which element from left subtree/right subtree is coming first in preorder
	 * , that will be root
	 * 
	 */
	public _105ConstructBinaryTreeFromPreOrderAndInorder constructBTFromPreorderAndInorder(int preorder[],
			int inorder[]) {
		return helper(0, 0, inorder.length - 1, preorder, inorder);

	}

	public _105ConstructBinaryTreeFromPreOrderAndInorder helper(int preStart, int inStart, int inEnd, int[] preorder,
			int[] inorder) {
		//boundary check 
		if(preStart>preorder.length-1 || inStart>inEnd) return null;
		//we know root node will always from preorder
		_105ConstructBinaryTreeFromPreOrderAndInorder root = new _105ConstructBinaryTreeFromPreOrderAndInorder(preorder[preStart]);
		//now find out the left subtree and right subtree
		// for left subtree , find the index in inorder array 
		int inIndex = 0;
		for(int i=0;i<=inEnd;i++)
		{
			if(root.val == inorder[i])
			{
				inIndex = i;
				
			}
			
		}
		// left sub child will be from inStart -> inIndex-1, why -1, because inIndexth element will be root so we will skip that
		//why preStart+1 because wee have already included preStart, so move to next element
		root.left = helper(preStart+1,inStart,inIndex-1,preorder,inorder);
		//short of a binary tree, 
		// now skip the elements already processed , so preStart will be preStart+inIndex-inStart+1
		root.right = helper(preStart+inIndex-inStart+1,inIndex+1,inEnd,preorder,inorder);
		
		return root;

	}

}
