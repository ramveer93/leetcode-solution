package leetcode.topinterview.questions;

public class DivideTwoNumbers29 {
	public static void main(String[] args) {

		System.out.println(divideTwoNumbers(-2147483648, -1));
	}

	public static int divideTwoNumbers(int a, int b) 
    {
        long count = 0;
        
        boolean negativeResult = false;
        if(a<0 || b<0) negativeResult = true;
        if(a<0 && b<0) negativeResult = false;
        
        if(a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
        
        a = Math.abs(a);
        b = Math.abs(b);
        
        if(b == 1) return (negativeResult)? -a: a;
        
        while(a-b>=0)
        {
            // if(count == Integer.MAX_VALUE) return Integer.MAX_VALUE;
            // else 
            count++;
            a = a-b;
          
            
           
            
        }
        return (negativeResult)?-1*(int)count:(int)count;
        
    }

}
