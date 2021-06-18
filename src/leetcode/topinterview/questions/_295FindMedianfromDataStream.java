package leetcode.topinterview.questions;

import java.util.Collections;
import java.util.PriorityQueue;

public class _295FindMedianfromDataStream {

	public static void main(String[] args) {

	}

	/** initialize your data structure here. */
	PriorityQueue<Integer> max;
	PriorityQueue<Integer> min;

	public _295FindMedianfromDataStream() {
		max = new PriorityQueue<>(Collections.reverseOrder());
		min = new PriorityQueue<>();
	}

	/**
	 * https://www.youtube.com/watch?v=EcNbRjEcb14
	 * 
	 * Add to max onnly if:
	 * 
	 * if(max.isEmpty() || max.top()>num){ max.add(num); }else{ min.add(n); }
	 * 
	 * balance both pqs
	 * 
	 * if(max.size()>min.size()+1) { min.add(max.top());
	 * 
	 * }else{ max.add(min.top()); }
	 * 
	 * 
	 */
	public void addNum(int num) {
		if (max.isEmpty() || max.peek() > num) {
			max.offer(num);
		} else {
			min.offer(num);
		}
		// now balance both PQs
		if (max.size() > min.size() + 1) {
			min.offer(max.peek());
			max.poll();

		} else if(min.size()>max.size()+1){
			max.offer(min.peek());
			min.poll();
		}

	}

	/**
	 * if both PQs have same size then median will be peek of both PQs/2.0 else
	 * median will be peek of longest heap: whichever has max size
	 */
	public double findMedian() {
		double res = 0;
		if (max.size() == min.size()) {
			res = (max.peek() + min.peek()) / 2.0;
		} else {
			res = max.size() > min.size() ? max.peek() : min.peek();
		}
		return res;
	}

}
