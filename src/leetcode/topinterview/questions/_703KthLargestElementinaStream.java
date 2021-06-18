package leetcode.topinterview.questions;

import java.util.PriorityQueue;

public class _703KthLargestElementinaStream {

	/**
	 * https://www.youtube.com/watch?v=G5CVOjWDAmY 
	 * 
	 * using min heap
	 * 
	 * if incoming element is greater then peek of pq then only it will have an impact on output
	 * else we can simply ignore it 
	 *
	 */

	PriorityQueue<Integer> pq;
	int k;

	public _703KthLargestElementinaStream(int k, int[] nums) {
		this.k = k;
		pq = new PriorityQueue<>();// min pq
		for (int i = 0; i < nums.length; i++) {
			this.add(nums[i]);

		}
	}

	public int add(int val) {

		if (pq.size() < k) {
			pq.add(val);
		} else if (val > pq.peek()) {
			pq.poll();
			pq.add(val);

		}
		return pq.peek();
	}

}
