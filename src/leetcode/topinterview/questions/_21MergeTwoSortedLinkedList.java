package leetcode.topinterview.questions;

public class _21MergeTwoSortedLinkedList {
	int value;
	_21MergeTwoSortedLinkedList next;

	_21MergeTwoSortedLinkedList() {
	};

	_21MergeTwoSortedLinkedList(int value) {
		this.value = value;
	};

	_21MergeTwoSortedLinkedList(int value, _21MergeTwoSortedLinkedList next) {
		this.value = value;
		this.next = next;
	};

	public static void main(String[] args) {

	}

	public _21MergeTwoSortedLinkedList mergeTwoLists(_21MergeTwoSortedLinkedList list1, _21MergeTwoSortedLinkedList list2) 
    {
		_21MergeTwoSortedLinkedList dummy_head = new _21MergeTwoSortedLinkedList(0);
		_21MergeTwoSortedLinkedList temp = dummy_head;

		while (list1 != null && list2 != null) {
			if (list1.value < list2.value) {
				temp.next = list1;
				list1 = list1.next;
			} else {
				temp.next = list2;
				list2 = list2.next;
			}
			temp = temp.next;
		}

		if (list1 != null) {
			temp.next = list1;
			list1 = list1.next;

		}

		if (list2 != null) {
			temp.next = list2;
			list2 = list2.next;

		}
		return dummy_head.next;
        
    }

}
