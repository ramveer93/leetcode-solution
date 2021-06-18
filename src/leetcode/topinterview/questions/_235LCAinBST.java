package leetcode.topinterview.questions;

public class _235LCAinBST {

	int val;
	_235LCAinBST left;
	_235LCAinBST right;

	_235LCAinBST(int val) {
		this.val = val;
	}

	_235LCAinBST(int val, _235LCAinBST left, _235LCAinBST right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	/**
	 * 
	 * https:// www.youtube.com/watch?v=TIoCCStdiFo
	 */
	public _235LCAinBST lcaInBST(_235LCAinBST root, _235LCAinBST p1, _235LCAinBST p2) {
		if (root == null)
			return root;
		return helper(root, p1, p2);
	}

	public _235LCAinBST helper(_235LCAinBST root, _235LCAinBST p, _235LCAinBST q) {
		int parentVal = root.val;
		int pVal = p.val;
		int qVal = q.val;

		if (parentVal > pVal && parentVal > qVal) {
			return helper(root.left, p, q);
		} else if (parentVal < pVal && parentVal < qVal) {
			return helper(root.right, p, q);
		} else
			return root;
	}

}
