package leetcode.topinterview.questions;

public class CashFree {

	public static void main(String[] args) {
		String x = "adcb";
		System.out.println(new CashFree().nextPermutation(x));
		
	}

	public String nextPermutation(String x) {
		if (x == null || x.length() == 0)
			return null;
		int n = x.length();
		char c[] = x.toCharArray();
		// abcd 4
		int k = n - 2;
		while (k >= 0 && c[k] >= c[k + 1]) {
			k--;

		}
		if (k == -1) {
			return reverse(x.toCharArray(), 0, n - 1);
		}
		System.out.println(k);
 //adcb-> bacd  bdca = > bacd
 /**
  * adcb
  * k = 2 
  * 
  */

		for (int i = n - 1; i > k; i--) {
			if (c[i] >= c[k]) {
				char temp = c[i];
				c[i] = c[k];
				c[k] = temp;
				break;

			}

		}
		System.out.println(new String(c));
		System.out.println(k);
		return reverse(c,k+1,n-1);

	}

	private String reverse(char[] x, int i, int j) {
		char t[] = x;
		while (i < j) {
			char c = t[i];
			t[i] = t[j];
			t[j] = c;
			i++;
			j--;

		}
		return new String(t);

	}

}
