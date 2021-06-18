package leetcode.topinterview.questions;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class _380InsertDeleteGetRandom {

	Map<Integer, Integer> map;
	List<Integer> list;

	public static void main(String[] args) {

	}

	/**
	 * https://www.youtube.com/watch?v=WtkwD7ikxfg
	 * 
	 * https://www.youtube.com/watch?v=Cbt6Ocj1XIA
	 * 
	 * 
	 * 
	 */

	/**
	 * 1. First check if element present in map or not if present return false
	 * 
	 * else add the element to array and add the element as key to map and value as
	 * its position in array
	 */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		} else {
			map.put(val, list.size());
			list.add(val);
			return true;
		}
	}

	/**
	 * If the value not present in map then return false
	 * 
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val))
			return false;
		else {
			int index = map.get(val);
			Collections.swap(list, index, list.size() - 1);
			int swappedElement = list.get(index);
			map.put(swappedElement, index);
			list.remove(list.size() - 1);
			map.remove(val);

			return true;
		}
	}

	/**
	 * generate a random value from 0 to list size ,this will be index in list
	 * 
	 */
	public int getRandom() {
		Random rand = new Random();
		int index = rand.nextInt(list.size());
		return list.get(index);

	}
}
