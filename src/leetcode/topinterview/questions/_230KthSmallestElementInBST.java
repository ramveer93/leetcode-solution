package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

public class _230KthSmallestElementInBST {
	int val;
	_230KthSmallestElementInBST left;
	_230KthSmallestElementInBST right;

	_230KthSmallestElementInBST(int val) {
		this.val = val;
	}

	_230KthSmallestElementInBST(int val, _230KthSmallestElementInBST left, _230KthSmallestElementInBST right) {
		this.left = left;
		this.right = right;
		this.val = val;
	}

	public int kthSmallestInBst(_230KthSmallestElementInBST root, int k) {

		List<Integer> res = new ArrayList<Integer>();
		res = bstInorder(root, res);
		return res.get(k - 1);
	}

	public List<Integer> bstInorder(_230KthSmallestElementInBST root, List<Integer> res) {
		if (root == null)
			return res;
		bstInorder(root.left, res);
		res.add(root.val);
		bstInorder(root.right, res);
		return res;

	}

}
