package leetcode.topinterview.questions;

public class _234PalindromeLinkedList {

	int val;
	_234PalindromeLinkedList next;

	_234PalindromeLinkedList(int val) {
		this.val = val;
	}

	_234PalindromeLinkedList(int val, _234PalindromeLinkedList next) {
		this.val = val;
		this.next = next;

	}

	public static void main(String[] args) {

	}

	/**
	 * 1. two pointers , slow and fast, stop when slow points to middle of
	 * linkedlist and fast to end of linkedList 2. reverse the right part of
	 * linkedlist: from slow to end of linked list 3. compare both the left and
	 * right part to find if it is palindrome
	 */
	public boolean isPalindromeLinkedList(_234PalindromeLinkedList head) {
		_234PalindromeLinkedList slow = head;
		_234PalindromeLinkedList fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		//this is where the odd no of elments exists in linked list
		 // 1 -> 2 -> 3
        //       s    f
		if(fast!=null) {
			slow = slow.next; //make slow as 3 here
			
		}
		// here slow will points to mid of linked list and fast to end of linked list
		// so reverse the linked list from slow to end of linked list
		_234PalindromeLinkedList end = reverse(slow);
		_234PalindromeLinkedList start = head;
		// now keep comparing every element in fast and slow while moving one step
		while (end != null && start != null) {
			if (end.val != start.val) {
				return false;

			}
			end = end.next;
			start = start.next;
		}
		return true;

	}

	public _234PalindromeLinkedList reverse(_234PalindromeLinkedList head) {
		if (head == null)
			return head;
		_234PalindromeLinkedList curr = head;
		_234PalindromeLinkedList next = null;
		_234PalindromeLinkedList prev = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;

	}
}
