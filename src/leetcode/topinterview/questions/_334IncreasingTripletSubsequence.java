package leetcode.topinterview.questions;

public class _334IncreasingTripletSubsequence {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5 };

		System.out.println(new _334IncreasingTripletSubsequence().increasingTriplet(a));
	}

	/**
	 * 
	 * Idea is to maintain two variables : min and secondMin 
	 */
	public boolean increasingTriplet(int a[]) {

		int n = a.length;
		if(n<3) return false;
		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		for(int i = 0;i<n;i++) {
			if(a[i]<=min) {
				min = a[i];
			}else if(a[i]<=secondMin) {
				secondMin = a[i];
				
			}else {
				System.out.println(min+" second min: "+secondMin+" third: "+a[i]);
				return true; // we already have 2 mins now this will be 3rd min element
			}
			
		}
		return false;

	}

	/**
	 * This is wrong solution We need to find the sub sequence so it may or may not
	 * be consequetive
	 * 
	 * @param a
	 * @return
	 */
	public boolean increasingTripletWRONG(int a[]) {

		int n = a.length;
		if (n <= 2)
			return false;
		int k = 2;
		for (int i = 0; i <= n - 2; i++) {
			if (a[i] < a[i + 1] && a[i + 1] < a[k]) {
				return true;
			}
			k++;

		}
		return false;

	}
}
