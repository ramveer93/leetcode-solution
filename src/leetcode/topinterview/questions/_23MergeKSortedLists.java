package leetcode.topinterview.questions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _23MergeKSortedLists {
	int val;
	_23MergeKSortedLists next;

	_23MergeKSortedLists() {
	};

	_23MergeKSortedLists(int val) {
		this.val = val;
	};

	_23MergeKSortedLists(int val, _23MergeKSortedLists next) {
		this.val = val;
		this.next = next;
	};

	public static void main(String[] args) {

	}

	public _23MergeKSortedLists mergeKsorted(_23MergeKSortedLists[] lists) {

		_23MergeKSortedLists dummy_head = new _23MergeKSortedLists(0);
		_23MergeKSortedLists temp = dummy_head;

		// create a PQ with comparator as increasing sorted
		PriorityQueue<_23MergeKSortedLists> pq = new PriorityQueue<>(new Comparator<_23MergeKSortedLists>() {
			public int compare(_23MergeKSortedLists o1, _23MergeKSortedLists o2) {
				return o1.val - o2.val;
			}
		});

		// add only the head node of all the nodes
		for (_23MergeKSortedLists headNode : lists) {
			if (headNode != null) {
				pq.add(headNode);
			}
		}
		// now we will take out from pq
		while (!pq.isEmpty()) {
			_23MergeKSortedLists node = pq.poll();
			temp.next = node;
			temp = temp.next;
			if (temp.next != null) {
				pq.add(temp.next);
			}
		}
		return dummy_head.next;

	}

}
