package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _239SlidingWindowMax {

	public static void main(String[] args) {

		int a[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int p[] = new _239SlidingWindowMax().slidingWindowMaxBruteForce(a, 3);
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);

		}

	}

	/**
	 * https://www.youtube.com/watch?v=39grPZtywyQ
	 * 
	 * peek: return the head or from front of element poll: will remove the element
	 * peekLast: return the last element of linked list
	 * 
	 * 
	 * we have to remove from tail and add to front
	 * 
	 * 
	 * 1. remove the head(peek) if the dq have more than k elements 2. Remove the
	 * last(pollLast) if the incoming element s greater than dp.peekLast 3. add the
	 * element to dq
	 */
	public int[] slidingWindowLinear(int a[], int k) {
		LinkedList<Integer> dq = new LinkedList<>();
		int n = a.length - 1;
		int res[] = new int[n - k + 1];// no of windows
		for (int i = 0; i < n; i++) {
			// first remove out of range elements from dq
			if (!dq.isEmpty() && dq.peek() < i - k + 1) { // head/first element will be the max element in dq
				dq.poll();
			}
			while (!dq.isEmpty() && a[dq.peekLast()] < a[i]) {
				dq.pollLast();
			}
			dq.offer(i);
			if (i - k + 1 >= 0) {
				res[i - k + 1] = a[dq.peek()];
			}
		}
		return res;
	}

	/**
	 * Time limit exceeded
	 * 
	 */
	public int[] slidingWindowMaxBruteForce(int a[], int k) {
		int n = a.length;
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = i; j < k + i & k + i <= n; j++) {
				// System.out.print(" "+a[j]);
				if (a[j] > max) {
					max = a[j];

				}
			}
			if (max != Integer.MIN_VALUE)
				res.add(max);
			// System.out.println();
		}
		int result[] = new int[res.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = res.get(i);
		}
		return result;

	}
//	private int maxInArray(int a[], int index, int k) {
//		int max = Integer.MIN_VALUE;
//		for(int i = index; i<k;i++) {
//			if(a[i]>max){
//				max = a[i];
//				
//			}
//		}
//		
//	}

}
