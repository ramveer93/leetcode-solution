package leetcode.topinterview.questions;

import java.util.LinkedList;
import java.util.Queue;

public class _994RottingOranges {

	public static void main(String[] args) {
		int a[][] = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 2 } };
		System.out.println(new _994RottingOranges().rottingOranges(a));
	}

	/**
	 * 1 represent fresh orange
	 * 2 represent rotting orange
	 * 0 represent no orange
	 * 
	 */
	/**
	 * https://www.youtube.com/watch?v=DU3kgZNtdwk
	 * 
	 * Idea is first add all the pairs of x and y to queue where ever there is a
	 * rotting orange now until queue is empty: peek from queue and check: 
	 * 1. if it is not going outside of grid 
	 * 2. if its value is 1(if it is orange) then make
	 * its value to 2// means this orange is rotten and put it in queue
	 * 
	 * Now to count the time : keep incrementing the time whenever we go inside
	 * while loop if totoal oranges == time count that means all fresh oranges are
	 * rotten so we return time count else -1
	 */
	public int rottingOranges(int a[][]) {
		Queue<Pair> queue = new LinkedList<>();
		int rows = a.length;
		int cols = a[0].length;

		int time = 0, totalOranges = 0, rotten = 0;
		for (int i1 = 0; i1 < rows; i1++) {
			for (int j1 = 0; j1 < cols; j1++) {
				if (a[i1][j1] == 1 || a[i1][j1] == 2) {
					totalOranges++;
				}
				if (a[i1][j1] == 2) {
					queue.offer(new Pair(i1, j1));
				}

			}

		}

		if (totalOranges == 0)
			return 0;
		while (!queue.isEmpty()) {

			int size = queue.size();
			rotten = rotten + size;
			if (rotten == totalOranges)// we have made all the fresh oranges rotten so return the time
				return time;

			time++;

			for (int k = 0; k < size; k++) {
				Pair pair = queue.peek();
				int i = pair.x;
				int j = pair.y;

				// check all 4 directions //i+1,j
				if (i + 1 < rows && a[i + 1][j] == 1) {// check two conditions : it should be in grid and should be
														// fresh
					a[i + 1][j] = 2;
					queue.add(new Pair(i + 1, j));

				}
				// i-1,j
				if (i - 1 >= 0 && a[i - 1][j] == 1) {
					a[i - 1][j] = 2;
					queue.add(new Pair(i - 1, j));

				}

				// i,j+1
				if (j + 1 < cols && a[i][j + 1] == 1) {
					a[i][j + 1] = 2;
					queue.add(new Pair(i, j + 1));

				}

				// i,j-1
				if (j - 1 >= 0 && a[i][j - 1] == 1) {
					a[i][j - 1] = 2;
					queue.add(new Pair(i, j - 1));

				}
				queue.poll();

			}

		}
		return -1;

	}

}

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
