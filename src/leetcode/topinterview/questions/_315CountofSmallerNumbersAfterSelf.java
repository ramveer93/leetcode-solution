package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _315CountofSmallerNumbersAfterSelf {

	public static void main(String[] args) {

		int a[] = { 5, 2, 6, 1 };
		System.out.println(new _315CountofSmallerNumbersAfterSelf().countSmaller(a).toString());
	}

	/**
	 * [5,2,6,1]
	 * 
	 */
	public List<Integer> countSmaller(int a[]) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			int count = 0;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					count++;
				}
			}
			res.add(count);
		}
		return res;
	}

	/**
	 * https://www.youtube.com/watch?v=buDoT9ESw1c 
	 * idea is to create a bst with one
	 * more field count
	 */
	public List<Integer> countSmallerEfficient(int a[]) {
		List<Integer> res = new ArrayList<>();
		if (a.length == 0)
			return res;
		TreeNodeBST root = new TreeNodeBST(a[a.length - 1]);// last element in array
		res.add(0); // no lesser elements than last element
		for (int i = a.length - 2; i >= 0; i--) {
			int count = helper(root, a[i]);
			res.add(count);

		}
		Collections.reverse(res);
		return res;
	}

	public int helper(TreeNodeBST root, int val) {
		int smaller = 0;
		TreeNodeBST temp = new TreeNodeBST(val);
		boolean isConnected = false;
		while (!isConnected) {
			if (temp.val < root.val) {
				root.count++;
				if (root.left == null) {
					root.left = temp;
					isConnected = true;
				} else {
					root = root.left;
				}

			} else { // temp.val>root.val
				smaller = smaller + root.count;
				if (root.right == null) {
					root.right = temp;
					isConnected = true;

				} else {
					root = root.right;
				}

			}

		}
		return smaller;

	}
}

class TreeNodeBST {
	int val;
	int count = 1;// this is to check how many nodes smaller than this
	TreeNodeBST left;
	TreeNodeBST right;

	TreeNodeBST(int val) {
		this.val = val;

	}

}