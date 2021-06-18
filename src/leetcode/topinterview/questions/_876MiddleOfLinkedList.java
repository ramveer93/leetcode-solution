package leetcode.topinterview.questions;

public class _876MiddleOfLinkedList {
	int val;
	_876MiddleOfLinkedList next;

	_876MiddleOfLinkedList(int val) {
		this.val = val;

	}

	/**
	 * 
	 * Store all the nodes of LL in array and then return a.length/2
	 */
	public _876MiddleOfLinkedList middleApproach1(_876MiddleOfLinkedList head) {

		_876MiddleOfLinkedList[] a = new _876MiddleOfLinkedList[100];
		int count = 0;
		while (head != null) {
			a[count++] = head;
			head = head.next;
		}
		return a[count / 2];

	}

	/**
	 * Efficient approach with two pointers one slow , fast pointer, when the fast
	 * reaches the end of ll , slow will point to middle of linked list
	 */
	public _876MiddleOfLinkedList middle(_876MiddleOfLinkedList head) {
		_876MiddleOfLinkedList slow = head;
		_876MiddleOfLinkedList fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

		}
		return slow;

	}

}
