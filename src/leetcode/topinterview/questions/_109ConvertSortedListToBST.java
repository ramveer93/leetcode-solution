package leetcode.topinterview.questions;

import java.util.LinkedList;

public class _109ConvertSortedListToBST {
	int val;
	_109ConvertSortedListToBST left;
	_109ConvertSortedListToBST right;

	_109ConvertSortedListToBST(int val) {
		this.val = val;
	}

	_109ConvertSortedListToBST(int val, _109ConvertSortedListToBST left, _109ConvertSortedListToBST right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	/**
	 * 
	 * what do we know: well we know if we have a sorted array then we can convert
	 * it into bst using _108 Now we have given a linkedList so we have to convert
	 * it into array and apply the same logic
	 */
	public _109ConvertSortedListToBST convertSortedLinkedListToBST(LinkedList<Integer> list) {
		if (list.size() == 0)
			return null;
		int a[] = new int[list.size()];
		// fill a from list
		for (int i = 0; i < list.size(); i++) {
			a[i] = list.get(i);

		}

		return helper(0, a.length - 1, a);
	}

	public _109ConvertSortedListToBST helper(int low, int high, int a[]) {
		// boundary check
		if (low > high) {
			return null;
		}
		int mid = (low + high) / 2;
		_109ConvertSortedListToBST root = new _109ConvertSortedListToBST(a[mid]);
		// left sub tree
		root.left = helper(low, mid - 1, a);
		root.right = helper(mid + 1, high, a);
		return root;
	}
}
