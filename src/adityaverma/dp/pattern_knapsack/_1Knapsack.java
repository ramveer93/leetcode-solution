package adityaverma.dp.pattern_knapsack;

import java.util.Arrays;

public class _1Knapsack {

	private static int[][] t;

	public static void main(String[] args) {

		/**
		 * wt[]: value[]: w max profit
		 */
		int n = 4;
		int w = 10;
		int[] wt = {4,2,10,15};
		int[] val = {10,4,1,2};
		t = new int[n + 1][w + 1];
		//Arrays.fill(t, -1);
		
		System.out.println(new _1Knapsack().knapsackDPTopDown(wt,val,w,n));
		

	}

	/**
	 * We need to find the max profit wt: weight array val: value array w: total
	 * weight of knapsack n: length of wt/val array
	 * 
	 * How to identify if it is dp problem or not: 1. recursion 2. optimal : find
	 * max/min/largest etc
	 * 
	 * once we find out this is dp problem then we need to code the recursion
	 * 
	 * before than we need to find the choice diagram 
	 *           ( wt,val ) 
	 *            /      \ 
	 *          wt<=w    wt>w 
	 *          / \
	 *         Y   N           N
	 * 
	 * Now we need to make the recursion code
	 * 
	 * two things in recursion code: 1. base case 2. choice diagram
	 * 
	 * 1. base case: get the minimal valid input So here we can have n==0 , w ==0
	 * if(n==0|| w==0)->return 0
	 * 
	 * 
	 */
	public int knapsack(int wt[], int[] val, int w, int n) {
		// base : min possible valid input
		if (n == 0 || w == 0)
			return 0;
		if (wt[n - 1] <= w) {
			return Math.max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1), knapsack(wt, val, w, n - 1));
		} else if (wt[n - 1] > w) {
			return knapsack(wt, val, w, n - 1);
		} else
			return 0;
	}

	/**
	 * what should be the size of matrix: from the recursion find the variables
	 * which are changing , here w and n Initialization: initialize it -1 dont pass
	 * the matrix to input to method instead use a global matrix variable
	 */
	public int knapsackMemoization(int wt[], int val[], int w, int n) {
		if (n == 0 || w == 0)
			return 0;

		if (t[n][w] != -1)
			return t[n][w];

		if (wt[n - 1] <= w) {
			return t[n][w] = Math.max(val[n - 1] + knapsackMemoization(wt, val, w - wt[n - 1], n - 1),
					knapsackMemoization(wt, val, w, n - 1));

		} else if (wt[n - 1] > w) {
			return t[n][w] = knapsackMemoization(wt, val, w, n - 1);

		} else
			return 0;
	}

	/**
	 * 1. dp table size: n+1Xw+1 , why 1 extra because in 0th row/col we will
	 * initialize the matrix 2. how to initialize: use the same base condition from
	 * recursion: n==0 || w==0 -> t[0][i] = 0 & t[i][0] = 0 3. convert recursion
	 * code dp code whereever there is a method call use t 4. at the end replace n
	 * to i and w to j 4. return t[n][w]
	 * 
	 */
	public int knapsackDPTopDown(int wt[], int val[], int w, int n) {
		int t[][] = new int[n + 1][w + 1];
		/**
		 * Base condition same as recursion: if n==0|| w==0->0
		 */
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;

			}

		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < w + 1; j++) {
				if (wt[i - 1] <= j) {
					t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);

				} else {
					t[i][j] = t[i - 1][j];
				}

			}

		}
		return t[n][w];
	}

}
