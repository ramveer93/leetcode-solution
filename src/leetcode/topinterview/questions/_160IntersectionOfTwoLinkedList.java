package leetcode.topinterview.questions;

public class _160IntersectionOfTwoLinkedList {
	int val;
	_160IntersectionOfTwoLinkedList next;

	public static void main(String[] args) {

	}

	/**
	 * Idea is to calculate the length of list1 , lets say it is l1 calculate the
	 * length of list2 , lets say it is l2
	 * 
	 * lets say l2 > l1
	 * 
	 * Now take two pointers , p1 = will start from start of l1 p2 will start from
	 * l2 - l1th position in list l2
	 * 
	 * move both with one step, utill they both are pointing to same node whenever
	 * they are pointing to same node , return that node
	 * 
	 */
	public _160IntersectionOfTwoLinkedList solve(_160IntersectionOfTwoLinkedList list1,
			_160IntersectionOfTwoLinkedList list2) {

		int l1 = 0, l2 = 0;
		_160IntersectionOfTwoLinkedList p1 = list1;
		_160IntersectionOfTwoLinkedList p2 = list2;

		while (p1 != null) {
			l1++;
			p1 = p1.next;

		}

		while (p2 != null) {
			l2++;
			p2 = p2.next;

		}
		p1 = list1;
		p2 = list2;

		if (l2 > l1) {
			for (int i = 0; i < l2 - l1; i++) {
				p2 = p2.next;

			}

		} else {
			// l1>l2
			for (int i = 0; i < l1 - l2; i++) {
				p1 = p1.next;

			}
		}
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;

		}
		return p1;

	}

}
