package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class _987VerticalOrderTraversalOfBinaryTree {

	/**
	 * https://www.youtube.com/watch?v=PQKkr036wRc
	 * 
	 */
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;

		Queue<TreeNode> nodeq = new LinkedList<>();
		Queue<Integer> hdq = new LinkedList<>();

		nodeq.add(root);
		hdq.add(0);
		Map<Integer, List<Integer>> map = new TreeMap<>();

		while (!nodeq.isEmpty()) {
			int size = nodeq.size();
			Map<Integer, List<Integer>> tempMap = new HashMap<>();

			for (int i = 0; i < size; i++) {
				TreeNode curr = nodeq.poll();
				int hd = hdq.poll();

				if (!tempMap.containsKey(hd)) {
					tempMap.put(hd, new ArrayList<>());
				}
				tempMap.get(hd).add(curr.val);

				if (curr.left != null) {
					nodeq.add(curr.left);
					hdq.add(hd - 1);
				}

				if (curr.right != null) {
					nodeq.add(curr.right);
					hdq.add(hd + 1);
				}

			}

			for (int key : tempMap.keySet()) {
				if (!map.containsKey(key))
					map.put(key, new ArrayList<>());
				List<Integer> list = tempMap.get(key);
				Collections.sort(list);
				map.get(key).addAll(list);

			}

		}

		res.addAll(map.values());
		return res;

	}

}
