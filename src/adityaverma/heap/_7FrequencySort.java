package adityaverma.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class _7FrequencySort {

	public static void main(String[] args) {
		int a[] = { 1, 3,3,3,3,3, 2, 2, 4 };
		int t[] = new _7FrequencySort().freqSort(a);
		for (int i = 0; i < a.length; i++)
			System.out.println(t[i]);
	}

	/**
	 * 
	 * https://www.youtube.com/watch?v=hLR5aMzYGGk&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=7
	 * 
	 * 
	 * 
	 * sort the frequent elements output should be 1,1,1,2,2,3,4
	 * 
	 * sort pq based on key: max key should come first
	 */
	public int[] freqSort(int a[]) {
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return p2.getKey() - p1.getKey();
			}
		});
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
		}

		int res[] = new int[a.length];
		int t = 0;
		for (Entry<Integer, Integer> e : map.entrySet()) {
			int k = e.getKey();
			int v = e.getValue();
			pq.add(new Pair(v, k));// k is element, v is freq
			//if (pq.size() > k) {
//				Pair pair = pq.poll();
//				for (int l = 0; l < pair.getKey(); l++) {
//					res[t++] = pair.getValue();
//				}
				
			//}
		}
		while (!pq.isEmpty()) {
			Pair pair = pq.poll();
			for (int l = 0; l < pair.getKey(); l++) {
				res[t++] = pair.getValue();
			}
		}

		return res;

	}
}
