package leetcode.topinterview.questions;

public class _206ReverseLinkedList {
	int val;
	_206ReverseLinkedList next;

	_206ReverseLinkedList(int val) {
		this.val = val;
	}

	_206ReverseLinkedList(int val, _206ReverseLinkedList next) {
		this.val = val;
		this.next = next;
	}

	public static void main(String[] args) {

	}

	public _206ReverseLinkedList reverse(_206ReverseLinkedList head) {
		if (head == null)
			return head;
		_206ReverseLinkedList prev = null;
		_206ReverseLinkedList curr = head;
		_206ReverseLinkedList next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;

		}
		return prev;

	}

}
