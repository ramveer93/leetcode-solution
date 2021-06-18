package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

public class _338CountingBits {

	public static void main(String[] args) {

		new _338CountingBits().countBits(5);
		
		int a[] = new _338CountingBits().countBits(5);
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
			
		}
	}

	/**
	 * 
	 * https://www.youtube.com/watch?v=awxaRgUB4Kw
	 * 
	 * 
	 * Simple pattern:
	 * if the number is even then the count of set bits will be equals to count of set bits in n/2
	 * if the number is odd then the count of set bits will be equals to the count of set bits in n/2 +1;
	 * 
	 * 
	 */
	public int[] countBitsEfficient(int n) {
		int bits[] = new int[n + 1];
		bits[0] = 0;
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0)
				bits[i] = bits[i / 2];
			else {
				bits[i] = 1 + bits[i / 2];
			}

		}
		return bits;

	}

	public int[] countBits(int n) {
		List<Integer> res = new ArrayList<>();
		res.add(0);
		if (n == 0)
			return new int[] { 0 };

		for (int i = 1; i <= n; i++) {
			int count = 0;
			int k = i;
			while (k > 0) {
				int temp = k % 2;
				if (temp == 1)
					count++;
				k = k / 2;
			}
			res.add(count);

		}
		int result[] = new int[res.size()];
		for (int i = 0; i < result.length; i++)
			result[i] = res.get(i);
		//System.out.println(res.toString());
		return result;

	}
}
