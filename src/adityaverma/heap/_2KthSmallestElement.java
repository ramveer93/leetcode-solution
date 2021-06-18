package adityaverma.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _2KthSmallestElement {

	public static void main(String[] args) {
		int a[] = { 2, 1, 4, 3, 2 };
		int k = 3;
		System.out.println(new _2KthSmallestElement().kthSmallest(a, k));
	}

	/**
	 * heap problem: k given asked smallest create pq of max
	 */
	public int kthSmallest(int a[], int k) {
//		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//			public int compare(Integer a1, Integer a2) {
//				return a2.compareTo(a1);
//			}
//		});
//		PriorityQueue<Integer> pq1 = new PriorityQueue<>( (x,y) -> y-x) ;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < a.length; i++) {
			pq.add(a[i]);
			if (pq.size() > k) {
				pq.poll();
			}

		}
		return pq.peek();

	}
}
