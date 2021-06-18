package leetcode.topinterview.questions;

import java.util.LinkedList;
import java.util.List;

public class _705DesignHashSet {

	/**
	 * https://www.youtube.com/watch?v=U79BoHTcCYw
	 */
	int noOfBuckets = 15000;
	List<Integer>[] buckets;

	public _705DesignHashSet() {
		buckets = new LinkedList[noOfBuckets];
	}

	private int hashFunction(int key) {
		return key % noOfBuckets;

	}

	public void add(int key) {
		int i = hashFunction(key);
		if (buckets[i] == null) {
			buckets[i] = new LinkedList<>();
		}
		if (buckets[i].indexOf(key) == -1) { // if the key doesnt exists then push it
			buckets[i].add(key);

		}

	}

	public void remove(int key) {
		int i = hashFunction(key);
		if (buckets[i] == null) {
			return; // if the element doesnt exists do nothing
		}
		if (buckets[i].indexOf(key) != -1) // element exists so remove it
		{
			buckets[i].remove(buckets[i].indexOf(key));

		}

	}

	public boolean contains(int key) {
		int i = hashFunction(key);
		if (buckets[i] == null || buckets[i].indexOf(key) == -1) {
			return false;
		} else
			return true;

	}

}
