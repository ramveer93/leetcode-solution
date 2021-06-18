package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56MergeIntervals {
	public static void main(String[] args) {
		int intervals[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int a[][] = new _56MergeIntervals().mergeIntervals(intervals);
		for(int i=0;i<a.length;i++)
		{
			
			System.out.print("("+a[i][0] +","+a[i][1]+")");
			System.out.println();
			
		}

	}

	/**
	 * idea is to sort the intervals first based on first number intervals = [
	 * [1,3],[2,6],[8,10],[15,18]] sorted: [[1,3],[2,6],[8,10],[15,18]]
	 * 
	 * Now apply logic: check if currentIntervals last >= next interval's first =>
	 * then update current interval else put it into output array
	 * 
	 * @param a
	 * @return
	 */
	public int[][] mergeIntervals(int intervals[][]) {

		List<int[]> res = new ArrayList<>();
		if (intervals.length == 1) {
			return intervals;
		}
		// sort the a based on first element of each element inside a
		Arrays.sort(intervals, (ar1,ar2) -> Integer.compare(ar1[0], ar2[0]));
		
		int[] currentInterval = intervals[0];
		res.add(currentInterval);
		for (int[] interval : intervals) {
			int current_begin = currentInterval[0];
			int current_end = currentInterval[1];
			int next_begin = interval[0];
			int next_end = interval[1];
			if (current_end >= next_begin) {
				currentInterval[1] = Math.max(current_end, next_end);
			} else {
				currentInterval = interval;
				res.add(interval);
			}

		}
		return res.toArray(new int[res.size()][]);

	}

//	class MyCustomComparator implements Comparator {
//
//		public int compare(Object a, Object b) {
//			int i = (int)a[0];
//			
//			int j = (Integer)b;
//			return i - j;
//
//		}
//	}
}
