package adityaverma.heap;

import java.util.PriorityQueue;

public class _10SumOfElementBwK1SmallestK2Smallest {

	public static void main(String[] args) {
		int a[] = {1,3,5,11,12,15};
		int k1 = 3;
		int k2 = 6;
		int s1 = new _10SumOfElementBwK1SmallestK2Smallest().kthSmallest(a, k1);
		int s2 = new _10SumOfElementBwK1SmallestK2Smallest().kthSmallest(a, k2);
	    
		int sum = 0;
		for(int i=0;i<a.length;i++) {
			if(a[i]>=s1 && a[i]<=s2) {
				sum+=a[i];
			}
		}
	    System.out.println(sum);
	}

	public int kthSmallest(int a[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y.compareTo(x));
		for (int i = 0; i < a.length; i++) {
			pq.add(a[i]);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.poll();
	}
}
