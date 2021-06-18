package javattest;

import java.util.PriorityQueue;

public class PriorityQueueExample 
{
	
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		/**
		 * adding elements to pq
		 */
		pq.add(12);
		pq.add(20);
		pq.add(15);
		pq.add(10);
		
		/**
		 * printing top element from pq
		 */
		System.out.println(" 1. ......"+pq.peek());
		System.out.println(" size "+pq.size());
		
		/**
		 * printing top element and removing it from pq
		 */
		System.out.println("polling ......"+pq.poll());
		System.out.println("size after polling....."+pq.size());
		
		
		System.out.println(" 2. ......"+pq.poll());
		System.out.println(" 3. ......"+pq.poll());
		System.out.println(" 4. ......"+pq.poll());
		System.out.println(" 5. ......"+pq.poll());
		if(pq.isEmpty()) {
			System.out.println("empty");
		}
		
		
		
	}

}
