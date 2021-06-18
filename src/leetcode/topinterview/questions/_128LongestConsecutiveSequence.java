package leetcode.topinterview.questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _128LongestConsecutiveSequence {
	public static void main(String[] args) {
		int a[] = { 100, 4, 200, 1, 3, 2 };
		System.out.println(new _128LongestConsecutiveSequence().longestConsecutiveSeq(a));
		System.out.println(new _128LongestConsecutiveSequence().naive(a));
		System.out.println(new _128LongestConsecutiveSequence().sort(a));

	}

	public int longestConsecutiveSeq(int a[]) {
		int result = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		for (int numb : set) {
			if (!set.contains(numb - 1)) {
				int currentNumber = numb;
				int currentStack = 1;
				while (set.contains(currentNumber + 1)) {
					currentStack++;
					currentNumber = currentNumber + 1;

				}
				result = Math.max(result, currentStack);
			}
		}
		return result;
	}

	public int naive(int a[]) {
		int lonest = 0;
		

		for (int i = 0; i < a.length; i++) {

			int currLeng = 1;
			int currNum = a[i];

			while (search(a, currNum+1 )) {
				currNum += 1;
				currLeng++;
			}
			lonest = Math.max(lonest, currLeng);

		}
		return lonest;

	}
	
	public int sort(int a[]) {
		int longest = 0;
		Arrays.sort(a);
		int currLen = 1;
		
		for(int i=1;i<a.length;i++) {
			if(a[i]!=a[i-1]) {
				
				if(a[i] == a[i-1]+1) {
					currLen++;
					
				}else {
					longest = Math.max(longest, currLen);
					currLen = 1;
				}
				
				
			}
			
		}
		return longest;
		
	}

	private boolean search(int a[], int k) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == k) {
				return true;
			}
		}
		return false;

	}

}
