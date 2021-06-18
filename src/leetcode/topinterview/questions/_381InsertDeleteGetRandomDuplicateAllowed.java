package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class _381InsertDeleteGetRandomDuplicateAllowed {

	Map<Integer, Set<Integer>> map;
	List<Integer> list;

	public _381InsertDeleteGetRandomDuplicateAllowed() {
		map = new HashMap<>();
		list = new ArrayList<>();
	}

	/**
	 * if val is exists in map then this is duplicate value, so we will update the
	 * set if not exists in map then insert to map and set
	 */
	public boolean insert(int val) {
		boolean exists = map.containsKey(val);
		if (!exists) {
			map.put(val, new LinkedHashSet<>());
			return true;
		} else {
			map.get(val).add(list.size());
			list.add(val);
			return false;
		}

	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		} else {
			int removeIndex = map.get(val).iterator().next();
			map.get(val).remove(removeIndex);
			int lastElement = list.get(list.size() - 1);
			list.set(removeIndex, lastElement);
			map.get(lastElement).add(removeIndex);
			map.get(lastElement).remove(list.size() - 1);
			list.remove(list.size() - 1);
			return true;

		}

	}

	public int getRandom() {
		Random rand = new Random();
		int index = rand.nextInt(list.size());
		return list.get(index);
	}
}
