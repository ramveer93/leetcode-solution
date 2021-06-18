package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

	public List<List<Integer>> levelorder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null)
			return res;
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				temp.add(curr.val);
				if (curr.left != null) {
					queue.add(curr.left);
				}
				if (curr.right != null) {
					queue.add(curr.right);
				}
			}
			res.add(temp);
		}
		return res;
	}

}
