package leetcode.topinterview.questions;

public class _344ReverseString {

	public static void main(String[] args) {
		String s = "hello";
		char a[] = s.toCharArray();
		new _344ReverseString().reverseString(a);
		
		System.out.println(new String(a));
		
	}
	
	public void reverseString(char a[]) {
		int start = 0;
		int end = a.length-1;
		while(start<end) {
			
			char temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
			
		}
		
	}
}
