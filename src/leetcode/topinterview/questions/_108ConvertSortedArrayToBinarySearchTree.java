package leetcode.topinterview.questions;

public class _108ConvertSortedArrayToBinarySearchTree {

	int val;
	_108ConvertSortedArrayToBinarySearchTree left;
	_108ConvertSortedArrayToBinarySearchTree right;

	_108ConvertSortedArrayToBinarySearchTree(int val) {
		this.val = val;

	}

	_108ConvertSortedArrayToBinarySearchTree(int val, _108ConvertSortedArrayToBinarySearchTree left,
			_108ConvertSortedArrayToBinarySearchTree right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public _108ConvertSortedArrayToBinarySearchTree convertSortedArrayToBST(int a[]) {

		// array, low, high
		return helper(0, a.length - 1, a);
	}

	/**
	 * 
	 * same logic as in _105 and _106
	 */
	public _108ConvertSortedArrayToBinarySearchTree helper(int low, int high, int a[]) {
		// boundary check
		if (low < high) {
			return null;

		}
		int mid = (low + high) / 2;

		_108ConvertSortedArrayToBinarySearchTree root = new _108ConvertSortedArrayToBinarySearchTree(a[mid]);
		root.left = helper(low, mid - 1, a);
		root.right = helper(mid + 1, high, a);
		return root;
	}

}
