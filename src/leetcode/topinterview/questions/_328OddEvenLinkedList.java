package leetcode.topinterview.questions;

public class _328OddEvenLinkedList {

	public static void main(String[] args) {

	}

	/**
	 * https://www.youtube.com/watch?v=ie1rKf7bpHw&feature=emb_title
	 * 
	 */
	public ListNode oddEvenList(ListNode head) {

		if (head == null)
			return null;

		ListNode odd = head;
		ListNode even = odd.next;
		ListNode evenHead = even;
		ListNode oddHead = head;

		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;

		}
		odd.next = evenHead;

		return oddHead;
	}
}
