package javattest;

public class CustomDS {

	public static void main(String[] args) {
		int c[] = new int[126];
		int a[] = {1,2,1,2,4,5,4};
		int t[] = new int[6];
		for(int i=0;i<a.length;i++) {
	       t[a[i]]++;		
		}
		
//		for(int i=0;i<t.length;i++) {
//			System.out.println("freq of : "+i+" is "+t[i]);
//		}
		
		String str = "abcabbcdklll";
		int cr[] =  new int[126];
		for(int i=0;i<str.length();i++) {
			cr[str.charAt(i)-'a']++;
		}
		for(int i=0;i<cr.length;i++) {
			System.out.println("freq of : "+str.charAt(i)+" is : "+cr[i]);
		}
		
	}
}
