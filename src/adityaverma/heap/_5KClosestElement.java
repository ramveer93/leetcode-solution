package adityaverma.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _5KClosestElement {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		int x = 3;
		int k = 4;
		int p[] = new _5KClosestElement().kClosestElement(a, k, x);
		for(int i=0;i<p.length;i++)System.out.println(p[i]);
	}

	/**
	 * a:  5,6,7,8,9  
	 * x = 7
	 * Closest: 2,1,0,1,2
	 * k =3;
	 * so closest will be 1,0,1==>6,7,8
	 * 
	 */
	public int[] kClosestElement(int a[], int k, int x) {
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return p2.getKey() - p1.getKey();
			}
		});
		
		for(int i=0;i<a.length;i++) {
			pq.add(new Pair(Math.abs(x-a[i]) , a[i]));
			if(pq.size()>k) {
				pq.poll();
			}
		}
		int []res = new int[k];
		int p = 0;
		while(!pq.isEmpty()) {
			res[p++] = pq.poll().getValue();
		}
		return res;

	}
}

class Pair {
	int key; //diff
	int value; //element

	Pair(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
