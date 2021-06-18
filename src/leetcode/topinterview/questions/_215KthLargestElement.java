package leetcode.topinterview.questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _215KthLargestElement {
	public static void main(String[] args) {

		int a[] = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		System.out.println(new _215KthLargestElement().kthLargest(a, 4));
	}

	/**
	 * 
	 */
	public int kthLargest(int a[], int k) {
		Integer ar[] = new Integer[a.length];
		for (int i = 0; i < a.length; i++)
			ar[i] = a[i];

		Arrays.sort(ar, Collections.reverseOrder());
		for (int i = 0; i < ar.length; i++)
			System.out.println(ar[i]);
		return ar[k - 1];

	}

	/**
	 * buid a max heap of the elements and then get from heap k times
	 * https://www.youtube.com/watch?v=aXJ-p3Qa4TY
	 * 
	 * @param a
	 * @return
	 * Time complexity: O(N+klogN) -> O(klogN) = > O(N) for building heap+O(logN) for doing on time heapify 
	 */
	public int usingMaxHeap(int a[], int k) {
		Queue<Integer> pq = new PriorityQueue<>(a.length, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);

			}
		});
		int res = 0;
		// now build a max heap, i mean put the elements in max heap
		for (int i = 0; i < a.length; i++) {
			pq.add(a[i]);

		}
		for (int i = 0; i < k; i++) {
			res = pq.poll();

		}
		return res;

	}

}
