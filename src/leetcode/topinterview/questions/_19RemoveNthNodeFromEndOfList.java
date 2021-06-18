package leetcode.topinterview.questions;

public class _19RemoveNthNodeFromEndOfList {
	int value;
	_19RemoveNthNodeFromEndOfList next;

	_19RemoveNthNodeFromEndOfList() {
	};

	_19RemoveNthNodeFromEndOfList(int value) {
		this.value = value;
	};

	/**
	 * https://www.youtube.com/watch?v=XtYEEvrhemI
	 * 
	 * take two pointers , 
	 * slow and fast
	 * keep the fast moving by n+1 steps , 
	 * then , move slow and fast by one untill the fast points to null 
	 * when fast points to null , the slow will point to n+1 from end node 
	 * then do slow.next = slow.nxt.next will delete the nth node 
	 * 
	 * @param head
	 * @param n
	 * @return 1->2->3->4->5 n =2;
	 * 
	 */
	public _19RemoveNthNodeFromEndOfList removeNthNodeFromLast(_19RemoveNthNodeFromEndOfList head, int n) {
		_19RemoveNthNodeFromEndOfList dummy_head = new _19RemoveNthNodeFromEndOfList(0);
        dummy_head.next = head;
        _19RemoveNthNodeFromEndOfList fast = dummy_head;
        _19RemoveNthNodeFromEndOfList slow = dummy_head;
        
        for(int i=1;i<=n+1;i++)
        {
            fast = fast.next;
            
        }
        while(fast!=null)
        {
            slow = slow.next;
            fast = fast.next;
            
        }
        slow.next = slow.next.next;
        return dummy_head.next;

	}
}
