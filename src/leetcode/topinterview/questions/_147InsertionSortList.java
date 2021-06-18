package leetcode.topinterview.questions;

public class _147InsertionSortList {

	public static void main(String[] args) {

	}

	/**
	 * https://www.youtube.com/watch?v=MP_Of5rZ6sQ
	 * 
	 * very hard to understand
	 */
	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return null;
		ListNode dummy = new ListNode(-1);
		ListNode curr = head;

		while (curr != null) {
			ListNode temp = curr.next;
			ListNode prev = dummy;
			ListNode nxt = dummy.next;

			while (nxt != null) {
				if (nxt.val > curr.val) {
					break;
				}
				prev = nxt;
				nxt = nxt.next;

			}
			curr.next = nxt;
			prev.next = curr;
			curr = temp;

		}

		return dummy.next;

	}
}
