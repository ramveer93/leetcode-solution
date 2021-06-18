package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _9PalindromNumber {
	public static void main(String[] args) 
	{

		//IsPalindromWithoutConvertingToString(1234);
		isPalindrome3(1234);
		
	}
	

	public static boolean IsPalindrom(int x) {
		String s = String.valueOf(x);
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;

			} else {
				return false;
			}

		}
		return true;
	}
	
	 public static void isPalindrome3(int n){
	        Stack<Integer> res = new Stack<>();
	        while(n>0){
	            
	            int rem = n%10;
	            n = n/10;
	            res.add(rem);
	        }
	        
	        
	    }
	 

	public static void IsPalindromWithoutConvertingToString(int n) {
		List<Integer> list = new ArrayList<>();
		
		while (n > 0) {
			//System.out.println(n % 10);
			list.add(n%10);
			n = n / 10;
		}

	}

}
