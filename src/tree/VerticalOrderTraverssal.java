package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraverssal {
	public static void main(String[] args) {
		
	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {
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
		res.addAll(map.values());

		return res;
	}
}
