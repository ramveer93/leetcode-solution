package leetcode.topinterview.questions;

public class _148SortList {
	int val;
	_148SortList next;

	_148SortList() {
	};

	_148SortList(int val) {
		this.val = val;

	}

	/**
	 * 
	 * We will use merge sort O(nlogn)
	 * 
	 * divide the list into two parts and then keep dividing until we get just two
	 * elements , then keep merging the sorted lists
	 * 
	 * so two things here: find the mid of the linked list : fast , slow pointer
	 * approach merge two sorted linked lists
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public _148SortList sortList(_148SortList head) {

		if (head == null || head.next == null) {
			return head; // if there are less than 2 nodes then just return the node

		}
		_148SortList mid = middle(head);
		_148SortList left = sortList(head);
		_148SortList right = sortList(mid);
		return merge(left, right);

	}

	public _148SortList merge(_148SortList list1, _148SortList list2) {
		_148SortList dummy = new _148SortList();
		_148SortList tail = dummy;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				tail.next = list1;

				list1 = list1.next;
				tail = tail.next;

			} else {
				tail.next = list2;
				list2 = list2.next;
				tail = tail.next;
			}
		}
		tail.next = (list1 != null) ? list1 : list2;
		return dummy.next;
	}

	/**
	 * same as _876 but there will be slightly change here, in case of _876 we dont
	 * have to break the linked list but here we have to break the linked list and
	 * point to null
	 */
	public _148SortList middle(_148SortList head) {
		_148SortList slow = null;
		while (head != null && head.next != null) {
			slow = (slow == null) ? head : slow.next;
			head = head.next.next;
		}
		_148SortList mid = slow.next;
		slow.next = null;

		return mid;

	}

}
