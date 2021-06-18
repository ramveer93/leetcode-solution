package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBT {

	public List<Integer> bottomView(TreeNode root) {

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
				if (!rowMap.containsKey(hd)) {
					rowMap.put(hd, new ArrayList<>());
				}
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
				List<Integer> temp = rowMap.get(key);
				Collections.sort(temp);
				map.get(key).addAll(temp);

			}

		}

		for (int k : map.keySet()) {
			List<Integer> t = map.get(k);
			res.add(t.get(t.size() - 1));
		}

		return res;

	}

}
