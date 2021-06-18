package leetcode.topinterview.questions;

public class ReverseOrSwapKNodeesInLL25 {
	public static void main(String[] args) {

	}

	
	/**
	 * https://www.youtube.com/watch?v=BfQeP6XEXEc
	 */
	public ListNode reverseInGroups(ListNode head, int k) {
		if(head==null || head.next!=null ||k ==1) return head;
		int n=0;
		ListNode curr = head;
		while(curr!=null) {
			n++;
			curr = curr.next;
		}
		curr = head;
		ListNode prev = null;
		ListNode next = null;
		ListNode t1 = null;
		ListNode t2 = head;
		ListNode newHead = null;
		
		while(n>=k) {
			for(int i=0;i<k;i++) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
			if(newHead!=null) {
				newHead = prev;
			}
			if(t1!=null) {
				t1.next = prev;
			}
			t2.next = curr;//if the ll is of size odd
			t1 = t2; //jump to next reversed ll
			t2 = curr; 
			prev = null;
			n = n-k;
		}
		return newHead;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/183356/Java-O(n)-solution-with-super-detailed-explanation-and-illustration
	 * 
	 * @param head
	 * @return
	 * 
	 * /**
 * This problem can be split into several steps:

Since we need to reverse the linked-list every k nodes, we need to check whether the number of list nodes are enough to reverse. 
Otherwise, there is no need to reverse.

If we need to reverse the k nodes, how to do that? Following is my idea:

If the structure of the linkedlist is like this:

 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
Then there will always be a pointer, which points to the node AHEAD of the first node to reverse. 
The pointer will help to link the linkedlist after.

At first, we will add a dummy node in front of the linked list to act as the first pointer. After we add the pointer, the linked list will look like this:

    0 (pointer) -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
Suppose that there are enough nodes to be reversed, we just use the "reverse linked list" trick to reverse the k nodes. Please refer to "https://leetcode.com/problems/reverse-linked-list/" if you don't know how to reverse a linked list.

if k = 3, we can reverse 1 to 3 first using the following code:

  ListNode prev = null, curr = pointer.next, next = null;
  for (int i = 0; i < k; i++) {
		next = curr.next;
		curr.next = prev;
		prev = curr;
		curr = next;
  }
This is the illustartion of the first 3 steps:

    step1: 0 (pointer) -> 1      2 -> 3 -> 4 -> 5 -> 6 -> 7
	step2: 0 (pointer) -> 1 <- 2      3 -> 4 -> 5 -> 6 -> 7
	step3: 0 (pointer) -> 1 <- 2 <- 3      4 -> 5 -> 6 -> 7
This is an easy and general algorithm to reverse a linked list. However, if you are careful enough, you will find that after the for-loop, the link from 3 to 4 will be cut (as shown in step3).

Now we need to reconstruct the linked list and fix the issue. You will figure out that at step3, the 3 is the prev node, 4 is the curr node.

	step3: 0 (pointer) -> 1 <- 2 <- 3 (prev)    4 (curr) -> 5 -> 6 -> 7
We can fix the sequence based on the following codes. The basic idea is to link the pointer to 3 and link 1 to 4:

	ListNode tail = pointer.next;
	tail.next = curr; 
	pointer.next = prev;
	pointer = tail;
Then the result is:

	after first line:   0 (pointer) -> 1 (tail) <- 2 <- 3 (prev)    4 (curr) -> 5 -> 6 -> 7
	after second line:  0 (pointer) -> 1 (tail) <- 2 <- 3 (prev)    4 (curr) -> 5 -> 6 -> 7
								       |____________________________↑
	after third line:   
								|-----------------------↓
						0 (pointer)    1 (tail) <- 2 <- 3 (prev)    4 (curr) -> 5 -> 6 -> 7
									   |____________________________↑
									   
	after forth line:	0 -> 3 -> 2 -> 1 (pointer) -> 4 -> 5 -> 6 -> 7
Now we get the new pointer, and we can repeat the process. Note that to retrieve the head, we need to record the first dummy node (0).
 * @author sramveer
 *
 */
	public ListNode reverseInKgroup(ListNode head, int k) {
		ListNode dummy_node = new ListNode(0);
		dummy_node.next = head;
		ListNode pointer = dummy_node;
		while (pointer != null) {
			// check if we have sufficient nodes to reverse
			ListNode node = pointer;
			for (int i = 0; i < k && node != null; i++) {
				node = node.next;
			}
			if (node == null)
				break;
			// now we have more than k nodes so we will reverse in group of k now
			ListNode prev = null, curr = pointer.next, next = null;
			for (int i = 0; i < k; i++) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
			// now we should join the already reversed ll and next ll
			ListNode tail = pointer.next;
			tail.next = curr;
			pointer.next = prev;
			pointer = tail;
		}
		return dummy_node.next;

	}
	
	
	

}
