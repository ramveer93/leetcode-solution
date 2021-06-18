package leetcode.topinterview.questions;

public class _237DeleteNodeInLinkedList {
	int val;
	_237DeleteNodeInLinkedList next;

	_237DeleteNodeInLinkedList(int val) {
		this.val = val;
	}

	_237DeleteNodeInLinkedList(int val, _237DeleteNodeInLinkedList next) {
		this.val = val;
		this.next = next;
	}

	/**
	 * https://www.youtube.com/watch?v=3XGaTq-bRiU&feature=emb_title
	 */
	public void deleteNode(_237DeleteNodeInLinkedList root) {
		root.val = root.next.val; // same as swap
		root.next = root.next.next;
	}

}
