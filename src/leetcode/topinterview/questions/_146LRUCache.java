package leetcode.topinterview.questions;

import java.util.LinkedHashMap;
import java.util.Map;

public class _146LRUCache {

	public static void main(String[] args) {

	}

	private Map<Integer, Integer> storage;

	int capacity;

	public _146LRUCache(int capacity) {
		this.capacity = capacity;
		this.storage = new LinkedHashMap<Integer, Integer>();

	}

	/**
	 * 
	 * https://www.youtube.com/watch?v=akFRa58Svug Idea of LRU cache is that we need
	 * to remove least recent used element
	 * 
	 * there are 2 operations get and put when ever we are trying to access an
	 * element , we need to check if that element exists in the cache or not to
	 * check that we need to do linear search in cache : so O(n) time
	 * 
	 * Now once the element found in cache then we need to shuffle the elements to
	 * make them LRU elements that will again take O(n) times
	 * 
	 * so for Q queries LRU cache will take Q.n time with array
	 * 
	 * 
	 * We can optimize both search and shuffle/remove operations to perform them in
	 * O(1)
	 * 
	 * For shuffle , we can use a Linked List as in LL we can easily shift the
	 * pointer of the head to point to next node in O(1) But here we may have to
	 * move left or right so we have to use Doubly linked list instead of Linked
	 * list
	 * 
	 * Now to optimize the search operation , we can use hash map which will give
	 * the time in O(1)
	 * 
	 * So for get: if the element exists in hash map , then remove it from both LL
	 * and hash map and then insert in to both
	 * 
	 * for put: if the element not exists in map and size == capacity , then remove
	 * the first element from map else if the element exists , then remove the
	 * element from hash map and linked list and then finally add that to both ll
	 * and hash map
	 * 
	 * 
	 * 
	 * We can use linkedHashMap
	 * 
	 */

	public int get(int key) {
		Integer value = storage.get(key);
		if (value == null) {
			return -1;

		} else {
			storage.remove(key);
			storage.put(key, value);
			return value;

		}

	}

	public void put(int key, int value) {
		if (storage.containsKey(key)) {
			storage.remove(key);

		} else {
			if (storage.size() == capacity) {
				Integer firstKey = storage.keySet().iterator().next();
				storage.remove(firstKey);

			}
		}
		storage.put(key, value);

	}
}
