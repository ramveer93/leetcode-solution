package adityaverma.heap;

import java.util.PriorityQueue;

public class _3KLargestElements {

	public static void main(String[] args) {
		int a[] = {7,10,4,3,20,15};
		int k = 2;
		new _3KLargestElements().kthLargest(a, k).toString();
	}

	/**
	 * https://www.youtube.com/watch?v=3DdP6Ef8YZM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=3
	 * Identification: k given 
	 * asked for largest create heap of type min heap
	 */
	public int[] kthLargest(int a[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < a.length; i++) {
			pq.add(a[i]);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		System.out.println(pq.toString());
		int res[] = new int[pq.size()];
		for(int i=0;i<pq.size();i++)res[i] = pq.poll();
		return res;
	}
}
