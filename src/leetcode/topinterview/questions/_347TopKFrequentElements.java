package leetcode.topinterview.questions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _347TopKFrequentElements {

	public static void main(String[] args) {

		int a[] = {1,1,1,2,2,3};
		int l[] = new _347TopKFrequentElements().topKFrequent(a, 3);
		for(int i=0;i<l.length;i++) {
			System.out.println(l[i]);
			
		}
	}

	/**
	 * 1. build a hash map with integer and frequency
	 * 
	 * 2. Build a heap with less frequent element first
	 * 
	 * 3. add to heap k elements, if heap size more than k then poll from heap,
	 * polling from heap will remove less frequent element first
	 * 
	 * 4. copy from heap to output array
	 */
	public int[] topKFrequent(int a[], int k) {
		int res[] = new int[k];
		if (a.length == 0)
			return res;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
		}
		// now build a heap with lest frequent element in top
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer n1, Integer n2) {
				return map.get(n1) - map.get(n2);
			}
		});

		// now put k elements in heap
		for (int n:map.keySet()) {
			pq.add(n);
			if (pq.size() > k)
				pq.poll();
		}

		for (int i = k-1;i>=0;--i) {
			res[i] = pq.poll();

		}

		return res;
	}
}
