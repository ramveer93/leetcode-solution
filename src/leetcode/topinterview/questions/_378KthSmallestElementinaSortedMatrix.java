package leetcode.topinterview.questions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _378KthSmallestElementinaSortedMatrix {

	public static void main(String[] args) {
		int a[][] = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		System.out.println(new _378KthSmallestElementinaSortedMatrix().kthSmallest(a, 8));

	}

	/**
	 * https://www.youtube.com/watch?v=cI3ivGemzsg
	 */
	public int kthSmallest(int a[][], int k) {

		PriorityQueue<Grid> heap = new PriorityQueue<>();
		// add first row to heap
		for (int i = 0; i < a[0].length; i++) {
			heap.add(new Grid(0, i, a[0][i]));
		}
		// now we have to have only k elements in queue so we will have to remove
		// elements from queue
		// when ever we remove from queue , we will add below element to queue
		// so if we remove a[i][j] from queue then we will add a[i+1][j] to queue
		int count = 0;

		while (!heap.isEmpty()) {
			Grid grid = heap.poll();
			count++;
			if (count == k) {
				return grid.val;
			}
			int rowIndex = grid.rowIndex;
			int colIndex = grid.colIndex;
			if (rowIndex + 1 < a.length) {
				heap.add(new Grid(rowIndex + 1, colIndex, a[rowIndex+1][colIndex]));
			}
		}
		return -1;
	}

	static class Grid implements Comparable<Grid> {
		int rowIndex;
		int colIndex;
		int val;

		public Grid(int rowIndex, int colIndex, int val) {
			this.rowIndex = rowIndex;
			this.colIndex = colIndex;
			this.val = val;

		}

		@Override
		public int compareTo(Grid o) {

			return this.val - o.val;
		}

	}
}
