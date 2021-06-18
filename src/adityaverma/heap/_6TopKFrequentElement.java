package adityaverma.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class _6TopKFrequentElement {

	public static void main(String[] args) {
		int a[] = { 1, 2, 2, 4,3,3,3 };
		int k = 1;
		int p[] = new _6TopKFrequentElement().topKFreqElement(a, k);
		for (int i = 0; i < p.length; i++)
			System.out.println(p[i]);
	}

	public int[] topKFreqElement(int a[], int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return p1.getKey() - p2.getKey();
			}
		});

		for (Entry<Integer,Integer>e: map.entrySet()) {
			int key = e.getKey();
			int value = e.getValue();
			
			pq.add(new Pair(value,key));
			if (pq.size() > k) {
				pq.poll();
			}

		}
		int res[] = new int[k];
		int t = 0;
		while (!pq.isEmpty()) {
			res[t++] = pq.poll().getValue();
		}
		return res;
	}
	
	 public int[] topKFrequent(int[] nums, int k) {
	        int res[] = new int[k];
	        if(nums.length == 0) return res;
	        Map<Integer,Integer> map = new HashMap<>();
	        for(int i=0;i<nums.length;i++){
	            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
	        }
	        //build a heap with less frequent in top
	        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>(){
	            public int compare(Integer n1, Integer n2){
	                return map.get(n1)-map.get(n2);
	            }
	        });
	        //fill the heap
	        for(int n : map.keySet()){
	            heap.add(n);
	            if(heap.size()>k) heap.poll();
	        }
	        //build result array from heap
	        for(int i = k-1;i>=0;--i){
	            res[i] = heap.poll();
	            
	        }
	        
	        return res;
	    }
}

