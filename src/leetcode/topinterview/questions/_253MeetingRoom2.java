package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _253MeetingRoom2 {

	public static void main(String[] args) {

		List<Interval> list = new ArrayList<>();
		Interval i1 = new Interval(0, 30);
		Interval i2 = new Interval(5, 10);
		Interval i3 = new Interval(15, 20);
		list.add(i1);
		list.add(i2);
		list.add(i3);
		

		System.out.println(new _253MeetingRoom2().meetingRooms(list));

	}

	/**
	 * https://www.youtube.com/watch?v=RBlcUlUkDCU
	 * 
	 * 
	 * 3rd most question to asked in Facebook interview input:
	 * [(0,30),(5,10),(15,20)]
	 * 
	 * if end of first meeting<start of next them we dont need a separate room else
	 * we need a separate room
	 * 
	 */
	public int meetingRooms(List<Interval> intervals) {
		// sort the intervals based on meeting's start time: [(0,30),(5,10),(15,20)]
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		// create a min heap so that we always have the min end time interval
		PriorityQueue<Integer> pq = new PriorityQueue<>();// this will be min priority queue to store end time of
															// meetings

		for (Interval interval : intervals) {
			if (!pq.isEmpty() && pq.peek() <= interval.start) { // that means we dont need a separate room
				pq.poll(); // we dont need a separate room
			} else {
				pq.offer(interval.end); // we need a seeparate room
			}

		}
		return pq.size();

	}

}

class Interval {
	int start;
	int end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;

	}
}
