package adityaverma.slidingwinndow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MaximumOfAllSubarraysofSizek {

	public static void main(String[] args) {
		int a[] = {-7,-8,7,5,7,1,6,0};
	    int p[] = new MaximumOfAllSubarraysofSizek().usingHeap(a, 4);
		//int p[] = new MaximumOfAllSubarraysofSizek().usingTreeHash(a, 4);
		
		for(int i=0;i<p.length;i++)System.out.println(p[i]);
		//3,3,5,5,6,7]
		
		
	}

	/**
	 * Time complexity: O(n*k)
	 */
	public int[] usingHeap(int a[], int k) {
		int i = 0;
		int j = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2.compareTo(i1);
			}
		});
		List<Integer> temp = new ArrayList<>();

		while (j < a.length) {
			pq.add(a[j]);
			if (j - i + 1 < k)
				j++;
			else if (j - i + 1 == k) {
				temp.add(pq.peek());
				pq.remove(a[i]);
				i++;
				j++;
			}

		}
		int[] res = new int[temp.size()];
		for (int p = 0; p < temp.size(); p++)
			res[p] = temp.get(p);
		return res;

	}
	
	public int[] usingTreeHash(int a[], int k ) {
		int i = 0;
		int j = 0;
		TreeSet<Integer> pq = new TreeSet<>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2.compareTo(i1);
			}
		});
		List<Integer> temp = new ArrayList<>();

		while (j < a.length) {
			pq.add(j);
			if (j - i + 1 < k)
				j++;
			else if (j - i + 1 == k) {
				temp.add(a[pq.first()]);
				pq.remove(i);
				i++;
				j++;
			}

		}
		int[] res = new int[temp.size()];
		for (int p = 0; p < temp.size(); p++)
			res[p] = temp.get(p);
		return res;
		
		//working
//		if(nums.length==0)
//            return new int[0];
//        
//        Comparator<Integer> cmp = (a,b)->{
//            return nums[a]!=nums[b]?Integer.compare(nums[a],nums[b]):a-b;
//        };
//        TreeSet<Integer> max_heap=new TreeSet<Integer>(cmp.reversed());
//        int count=0;
//        int[] max=new int[nums.length-k+1];
//        for(int i=0;i<k;i++)
//            max_heap.add(i);
//        
//        for(int i=k;i<nums.length;i++)
//        {
//            int el=max_heap.first();
//            max[count++]=nums[el];
//            max_heap.remove(i-k);
//            max_heap.add(i);            
//        }
//        max[count]=nums[max_heap.first()];
//        return max;
		
	}

	public List<Integer> maxOfAllSubArrays(int a[], int k) {

		List<Integer> res = new ArrayList<>();

		int i = 0;
		int j = 0;
		while (j < a.length) {
			// calculation
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				// collect the answer
				// slide the window

			}

		}
		return res;
	}

}
