package leetcode.topinterview.questions;

public class _285InorderSuccessornBST {

	public static void main(String[] args) {

	}

	/**
	 * https://www.youtube.com/watch?v=JdmAYw5h3G8
	 * 
	 * Inorder successor in bst of a node is node which is next higher to current
	 * node if current node has value: 30 and tree has 31 in it , then inorder
	 * successor will be 31
	 * 
	 * Approach: 1. we can take inorder traversal and can return the node which has
	 * value just max to p
	 * 
	 * 
	 * 2: case 1: ------>
	 * 
	 * if the node has a right sub tree then find the least value node from that
	 * right subtree
	 * 
	 * if(p.right!=null){ TreeNode temp = p.right; while(temp.left!=null){ temp =
	 * temp.left } print temp; }
	 * 
	 * case 2: --->
	 * 
	 * when p doesnt have right child , in this case we will search the p starting from root 
	 * every time we go to left direction we will update the successor 
	 * q = root;
	 * while(q!=null){
	 * 	if(q.val>p.val){
	 * 		succ = q;
	 * 		q = q.left;
	 * 	}else if(q.val<p.val){
	 *  q = q.right;
	 * 
	 * 	}else{
	 *  break;
	 * }
	 * }
	 * return succ;
	 * 
	 * Time: O(H);, H is the height of the bst 
	 */
	public TreeNode inorderSuccssor(TreeNode root, TreeNode p) {
		if (root == null || p == null) {
			return null;

		}
		TreeNode succ = null;
		TreeNode q = root;
		// first case when p has a right child
		if (p.right != null) {
			succ = p.right;
			while (succ.left != null) {
				succ = succ.left;
			}
			return succ;
		}

		// 2nd case when p doesn't have right child , in this case we will search the p
		// node starting from root
		// then we will return the node from where last left path starts
		while (q != null) {
			if (q.val > p.val) {
				succ = q;
				q = q.left; // this is where we have to count
			} else if (q.val < p.val) {
				q = q.right; // we are going to right so wont update the succ node as we need to count the last left path start 
			} else {
				break;
			}

		}
		return succ;

	}
}
