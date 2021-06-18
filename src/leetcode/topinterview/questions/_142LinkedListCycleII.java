package leetcode.topinterview.questions;

public class _142LinkedListCycleII {
	int val;
	_142LinkedListCycleII next;

	_142LinkedListCycleII(int val) {
		this.val = val;

	}

	_142LinkedListCycleII(int val, _142LinkedListCycleII next) {
		this.val = val;
		this.next = next;

	}

	public _142LinkedListCycleII detectCycle(_142LinkedListCycleII head) {
		_142LinkedListCycleII slow = head, fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) // cycle exist
			{
				while (head != slow) {
					head = head.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}

	/**
	 * 
	 * two pointers: fast and slow first detect a cycle: if there is a cycle then
	 * return the node where cycle found Node start from head and find the pointer
	 * where both start pointer and pointer from cycle found
	 * 
	 */
	public _142LinkedListCycleII findCycle(_142LinkedListCycleII head) {

		_142LinkedListCycleII dummy = head;

		_142LinkedListCycleII temp = isCycle(dummy);

		while (head != temp) {
			if (head == null || temp == null) {
				return null;

			}
			head = head.next;
			temp = temp.next;
		}
		return temp;

	}

	public _142LinkedListCycleII isCycle(_142LinkedListCycleII head) {
		if (head == null)
			return null;
		_142LinkedListCycleII slow = head;
		_142LinkedListCycleII fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return null;

			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;

	}

}
