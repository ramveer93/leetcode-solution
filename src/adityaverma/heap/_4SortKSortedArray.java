package adityaverma.heap;

import java.util.PriorityQueue;

/**
 * sort Nearly sorted array
 * @author sramveer
 *
 */
public class _4SortKSortedArray {

	public static void main(String[] args) {
		int a[] = {6,5,3,2,8,10,9,34,234};
		int k = 3;
		
		int t[] = new _4SortKSortedArray().sortNearlySorted(a, k);
		for(int i=0;i<a.length;i++)System.out.println(t[i]);
	}
	
	/**
	 * 
	 */
	public int[] sortNearlySorted(int a[], int k) {
		PriorityQueue<Integer>pq = new PriorityQueue<>();
		int res[] = new int[a.length];
		int t = 0;
		for(int i=0;i<a.length;i++) {
			pq.add(a[i]);
			if(pq.size()>k) {
				res[t++] = pq.poll();
			}
		}
		while(!pq.isEmpty()) {
			res[t++] = pq.poll();
		}
		return res;
	}
}
