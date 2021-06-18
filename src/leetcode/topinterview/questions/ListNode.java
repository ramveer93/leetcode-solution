package leetcode.topinterview.questions;

public class ListNode 
{
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	
	
	class Solution {
	    int carry = 0;
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
	    {
	        ListNode res = new ListNode(0) , temp = res;
	       
	        
	        while(l1!=null || l2!=null)
	        {
	            if(l1!=null && l2!=null)
	            {
	                res.next = add(l1.val,l2.val);
	                l1 = l1.next;
	                l2 = l2.next;
	                
	            }else if(l1!=null)
	            {
	                res.next = add(l1.val,0);
	                l1 = l1.next;
	                
	            }else if(l2!=null)
	            {
	                res.next = add(0,l2.val);
	                l2 = l2.next;
	                
	            }
	            res = res.next;   
	        }
	        if(carry!=0)
	        {
	            res.next = new ListNode(carry);
	            
	        }
	        
	        return temp.next;
	        
	      
	        
	    }
	      private ListNode add(int a, int b)
	        {
	            int s = a+b+carry;
	            carry = s/10;
	            //s = s%10;
	          ListNode temp = new ListNode(s%10);
	          
	          return temp;
	            
	        }
	}
	
	
}
