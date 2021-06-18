package leetcode.topinterview.questions;

public class _155MinStackV2 {

	private class Node {
		int val;
		int min;
		Node next;

		Node(int val, int min) {
			this.val = val;
			this.min = min;
			this.next = null;

		}

		Node(int val, int min, Node next) {
			this.val = val;
			this.min = min;
			this.next = next;

		}

	}

	private Node head;

	public void push(int x) {
		if (head == null) {
			head = new Node(x, x);
		} else {
			head = new Node(x, Math.min(head.min, x), head);
		}

	}

	public void pop() {
		head = head.next;

	}

	public int top() {
		return head.val;

	}

	public int getMin() {
		return head.min;

	}

}
