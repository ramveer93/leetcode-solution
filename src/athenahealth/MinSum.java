package athenahealth;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Given an array of integers, perform some number k of operations. Each
 * operation consists of removing an element from the array, dividing it by 2
 * and inserting the ceiling of that result back into the array. Minimize the
 * sum of the elements in the final array.
 * 
 * 
 * Example:
 * 
 * nums = [10, 20, 7]
 * 
 * k = 4
 * 
 * 
 * 
 * Pick Pick/2 Ceiling Result
 * 
 * Initial array [10, 20, 7]
 * 
 * 7 3.5 4 [ 10, 20, 4]
 * 
 * 10 5 5 [5, 20, 4]
 * 
 * 20 10 10 [5, 10, 4]
 * 
 * 10 5 5 [5, 5, 4]
 * 
 * 
 * 
 * The sum of the final array is 5 + 5 + 4 = 14, and that sum is minimal.
 * 
 *
 */

public class MinSum {

	public static void main(String[] args) {
		int a[] = {10,20,7};
		System.out.println(new MinSum().minSum(a, 4));

	}

	public int minSum(int a[], int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2.compareTo(i1);

			}
		});

		// 20 10 7
		for (int i = 0; i < a.length; i++) {
			pq.add(a[i]);
		}

		while (!pq.isEmpty() && k > 0) {
			int temp = pq.poll();
			int newTemp = (int)Math.ceil((double)temp/2);
			pq.add(newTemp);
			k--;
		}
		int minSum = 0;
		while (!pq.isEmpty()) {
			minSum += pq.poll();
		}

		return minSum;
	}

}
