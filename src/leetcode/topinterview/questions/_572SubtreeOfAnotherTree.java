package leetcode.topinterview.questions;

public class _572SubtreeOfAnotherTree {

	/**
	 * https://www.youtube.com/watch?v=HdMs2Fl_I-Q recursion
	 * 
	 * focus on curr node if you can get some thing
	 */

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null)
			return false;
		else if (isSame(s, t)) {
			return true;
		} else {
			return isSubtree(s.left, t) || isSubtree(s.right, t);
		}
	}

	public boolean isSame(TreeNode s, TreeNode t) {
		if (s == null || t == null) {
			return s == null && t == null;
		} else if (s.val == t.val) {
			return isSame(s.left, t.left) && isSame(s.right, t.right);

		} else {
			return false;
		}
	}
}
