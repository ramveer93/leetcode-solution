package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

	TreeMap<Integer, Integer> map = new TreeMap<>();

	/**
	 * https://www.youtube.com/watch?v=c3SAvcjWb1E
	 * 
	 * 
	 * JUST PRINT THE 0th ELEMENT ONLY FROM THE VERTICAL ORDER TRAVERSAL
	 */
	public List<Integer> topView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		Queue<TreeNode> nodeq = new LinkedList<>();
		Queue<Integer> hdq = new LinkedList<>();
		nodeq.add(root);
		hdq.add(0);

		Map<Integer, List<Integer>> map = new TreeMap<>();

		while (!nodeq.isEmpty()) {
			int size = nodeq.size();
			Map<Integer, List<Integer>> rowMap = new HashMap<>();
			for (int i = 0; i < size; i++) {
				TreeNode curr = nodeq.poll();
				int hd = hdq.poll();

				if (!rowMap.containsKey(hd))
					rowMap.put(hd, new ArrayList<>());
				rowMap.get(hd).add(curr.val);

				if (curr.left != null) {
					nodeq.add(curr.left);
					hdq.add(hd - 1);

				}
				if (curr.right != null) {
					nodeq.add(curr.right);
					hdq.add(hd + 1);

				}

			}
			for (int key : rowMap.keySet()) {
				if (!map.containsKey(key))
					map.put(key, new ArrayList<>());
				List<Integer> t = rowMap.get(key);
				Collections.sort(t);
				map.get(key).addAll(t);

			}

		}

		for (int k : map.keySet()) {
			res.add(map.get(k).get(0));

		}

		return res;

	}

	public void topViewOfBs(TreeNode root) {
		topviewEfficient(root, 0);
	}

	/**
	 * NO NEED TO SEE THIS , THE EARLIER VERSION IS VERY MUCH READABLE 
	 */
	public void topviewEfficient(TreeNode root, int level) {
		if (root == null)
			return;

		Queue<QueuePack> queue = new LinkedList<>();
		queue.add(new QueuePack(root, level));

		while (!queue.isEmpty()) {
			QueuePack q = queue.poll();
			TreeNode curr = q.node;
			int hd = q.level;
			if (!map.containsKey(hd)) {
				map.put(hd, curr.val);
				System.out.println("----->" + curr.val);
			}

			if (curr.left != null) {
				queue.add(new QueuePack(curr.left, hd - 1));

			}

			if (curr.right != null) {
				queue.add(new QueuePack(curr.right, hd + 1));

			}

		}

	}

	class QueuePack {
		TreeNode node;
		int level;

		QueuePack(TreeNode node, int level) {
			this.node = node;
			this.level = level;

		}
	}

}
