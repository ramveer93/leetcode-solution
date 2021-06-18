package leetcode.topinterview.questions;

import java.util.HashSet;
import java.util.Set;

public class _141LinkedListCycle {
	_141LinkedListCycle next;
	int val;

	_141LinkedListCycle(int val) {
		this.val = val;

	}

	_141LinkedListCycle(int val, _141LinkedListCycle next) {
		this.val = val;
		this.next = next;

	}

	/**
	 * Idea is to take two pointers , slow and fast move fast pointer : fast =
	 * fast.next.next and slow = slow.next if they both are equal some where , that
	 * is the cycle point and return true else false;
	 */
	public boolean cycle(_141LinkedListCycle head) {
		if (head == null)
			return false;
		_141LinkedListCycle slow = head;
		_141LinkedListCycle fast = head.next;

		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;

	}

	/**
	 * store in a set and then see if we alrady have this node in set then return true else false
	 */
	public boolean cycleUsingHashSet(_141LinkedListCycle head) {
		Set<_141LinkedListCycle> hs = new HashSet<>();

		while (head != null) {
			if (hs.contains(head)) {
				return true;

			} else {
				hs.add(head);
			}
			head = head.next;

		}
		return false;
	}

}
