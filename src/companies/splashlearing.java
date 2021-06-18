package companies;

import java.util.Arrays;

public class splashlearing {

	public static void main(String[] args) {
		//Simple_Recursive_Sequence(5,10);
		System.out.println(solve("caac"));
	}
	
	
	 static String solve(String s){
	       // Write your code here
	       if(s.length()==1 ) return "-1";
	       char c[] = s.toCharArray();
	       Arrays.sort(c);
	       StringBuffer sb = new StringBuffer(new String(c));
	       return sb.reverse().toString();
	      // return new String(c);
	    
	    }
	 
	 static int[] Simple_Recursive_Sequence(int k, int t){
	    
		 int a[] = new int[t+1];
		 a[0] = 1;
		 int b[] = new int[t+1];
		 b[0] = 2;
		 
		 int a0 = 1;
		 int b0 = 2;
		 for(int i=1;i<=t;i++) {
			 a[i] = (k*b[i-1]+a[i-1]*a[i-1])%3001;
			 b[i] = (k*a[i-1]+b[i-1])%3001;
			 
			 
		 }
		 System.out.println("a0: "+a[t]+" b0: "+b[t]);
		 return new int[] {a[t],b[t]};
		// System.out.println("a0: "+a0+" b0: "+b0);
		 
	       
	    
	    }
	
	public int str(String x, String y) {
		char cr[] = x.toCharArray();
		for(char c: cr) {
			cr[c]++;
		}
		int tins = 0;
		int j = 0;
		int i = 0;
		int min = 0;
		
		while(j>x.length()) {
			
			if(--cr[x.charAt(j)]>=0) {
				tins++;
			}
			
			while(tins==x.length()) {
				int len = j-i+1;
				if(min>len) {
					min = len;
				}
				if(++cr[x.charAt(i)]>0) {
					tins--;
					
				}
				i++;
				
			}
			
		}
		
		return min;
		
	}
	
}
