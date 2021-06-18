package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * heap is implemented in java using priority queue
 * 
 * @author sramveer https://www.youtube.com/watch?v=ptYUCjfNhJY
 */
public class _23MergeKsortedArrays {

	public static void main(String[] args) {
		int[] arr1 = { 1, 4, 7 };
		int[] arr2 = { 2, 5, 8 };
		int[] arr3 = { 3, 6, 9 };

		new _23MergeKsortedArrays().efficient(new int[][] { arr1, arr2, arr3 });
		

	}

	/**
	 * https://www.youtube.com/watch?v=0NMWBgU9C8Q
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode dummy_node = new ListNode(0);
		ListNode temp = dummy_node;
		Queue<ListNode> pq = new PriorityQueue<>((a, b) -> ((ListNode) a).val - ((ListNode) b).val);

		for (ListNode node : lists) {
			if (node != null) {
				pq.add(node);
			}
		}
		while (!pq.isEmpty()) {
			ListNode node = pq.poll();
			temp.next = node;
			temp = temp.next;
			if (temp.next != null) {
				pq.add(temp.next);

			}
		}
		return dummy_node.next;

	}

	/**
	 * NOT EFFICIENT SOLUTION
	 */
	public static int[] mergeKSortedArray(int[][] arr) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {
				queue.add(arr[i][j]);
			}
		}
		int[] result = new int[queue.size()];

		int index = 0;

		while (!queue.isEmpty()) {
			result[index++] = queue.poll();
		}

		return result;
	}

	/**
	 * int[] arr1 = { 1, 3, 5, 7 }; int[] arr2 = { 2, 4, 6, 8 }; int[] arr3 = { 0,
	 * 9, 10, 11 };
	 */
	public int[] efficient(int a[][]) {
		PriorityQueue<QueueNode> pq = new PriorityQueue<>();
		int size = 0;
		for (int i = 0; i < a.length; i++) {
			size += a[i].length;
			if (a[i].length > 0) {
				pq.add(new QueueNode(i, 0, a[i][0]));
			}
		}
		int res[] = new int[size];
		List<Integer> r = new ArrayList<>();

		int p = 0;
		while (!pq.isEmpty()) {
			QueueNode node = pq.poll();
			res[p++] = node.value;
			r.add(node.value);
			int newIndex = node.index + 1;
			// check if newindex is last index in this array
			if (newIndex < a[node.whichArray].length) {
				pq.add(new QueueNode(node.whichArray, newIndex, a[node.whichArray][newIndex]));
			}

		}
		System.out.println(r.toString());
		return res;

	}

	

}

class QueueNode implements Comparable<QueueNode> {

	int whichArray, index, value;

	public QueueNode(int whichArray, int index, int value) {
		this.whichArray = whichArray;
		this.index = index;
		this.value = value;
	}

	public int compareTo(QueueNode n) {
		if (value > n.value)
			return 1;
		if (value < n.value)
			return -1;
		return 0;
	}

}
