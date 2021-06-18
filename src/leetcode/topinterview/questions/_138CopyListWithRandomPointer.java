package leetcode.topinterview.questions;

import java.util.HashMap;
import java.util.Map;

public class _138CopyListWithRandomPointer {
	int val;
	_138CopyListWithRandomPointer next;
	_138CopyListWithRandomPointer random;

	_138CopyListWithRandomPointer(int val, _138CopyListWithRandomPointer next, _138CopyListWithRandomPointer random) {
		this.val = val;
		this.next = next;
		this.random = random;
	}

	_138CopyListWithRandomPointer(int val) {
		this.val = val;

	}

	/**
	 * https://www.youtube.com/watch?v=OvpKeraoxW0
	 * 
	 * The problem is that if it is a simple linked list with next pointer , we can
	 * copy that as we know the next pointer will be next node But here we have a
	 * random pointer , so when we are at 0th node , the random pointer may be
	 * pointing to 3rd node but 3rd node is not yet copied , so we have difficulty.
	 * ----------------xxxx---------------------
	 * 
	 * The idea is to store all the nodes without any connection in hashmap : first
	 * pass then take the node from hashmap and do the connection for next pointer:
	 * we can point the map.get(temp).next = map.get(temp.next);
	 * map.get(temp).random = map.get(temp.random);
	 */
	public _138CopyListWithRandomPointer solve(_138CopyListWithRandomPointer head) {

		if (head == null)
			return head;
		Map<_138CopyListWithRandomPointer, _138CopyListWithRandomPointer> map = new HashMap<>();

		// in first pass just create non connected lists and put in map
		_138CopyListWithRandomPointer node = head;
		while (node != null) {
			map.put(node, new _138CopyListWithRandomPointer(node.val));
			node = node.next;

		}
		node = head;
		// in second pass we have to adjust the next and random pointers
		while (node != null) {
			map.get(node).next = map.get(node.next); // map.get(node) will give the non connected node at node key, now
														// we have to
			// set the next of this , so next of this will be same as next of whatever node
			// was there in map at key node.next
			map.get(node).random = map.get(node.random);
			node = node.next;

		}

		return map.get(head);

	}

}
