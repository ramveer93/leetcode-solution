package leetcode.topinterview.questions;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _252MeetingRooms {

	public static void main(String[] args) {

	}

	/**
	 * https://www.youtube.com/watch?v=6Ygq6wXM4-I 
	 * 
	 * we have to find if a person can
	 * attend all the given meetings without any conflict [(0,30),(5,10),(15,20)]
	 * The idea is to sort the Intervals based on start time of intervals then if
	 * interval.end>interval.start then there is a conflict and he cant attend all
	 * meetings
	 */
	public boolean findIfPersonCanAttendAllMeetings(List<Intervals> intervals) {
		Collections.sort(intervals, new Comparator<Intervals>() {
			@Override
			public int compare(Intervals o1, Intervals o2) {
				return o1.start - o2.start;
			}
		});
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i - 1).end > intervals.get(i).start) {
				return false;
			}

		}

		return true;
	}
}

class Intervals {
	int start;
	int end;

	public Intervals(int start, int end) {
		this.end = end;
		this.start = start;

	}
}
