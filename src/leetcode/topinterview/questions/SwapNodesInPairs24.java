package leetcode.topinterview.questions;

public class SwapNodesInPairs24 {

	int val;
	SwapNodesInPairs24 next;

	SwapNodesInPairs24() {
	};

	SwapNodesInPairs24(int val) {
		this.val = val;
	}

	SwapNodesInPairs24(int val, SwapNodesInPairs24 next) {
		this.val = val;
		this.next = next;
	}

	public static void main(String[] args) {

	}

	/**
	 * https://www.youtube.com/watch?v=jiLloHVmLDc
	 * 
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = head;
		ListNode newStart = p.next;
		ListNode q = null;
		ListNode temp = null;

		while (true) {
			q = p.next;
			temp = q.next;
			q.next = p;
			if (temp == null) {
				p.next = null;
				break;

			}
			if (temp.next == null) {
				p.next = temp;
				break;

			}
			p.next = temp.next;
			p = temp;

		}
		return newStart;
	}

}
