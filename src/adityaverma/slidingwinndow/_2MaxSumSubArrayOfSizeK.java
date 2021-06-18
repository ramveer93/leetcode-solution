package adityaverma.slidingwinndow;

public class _2MaxSumSubArrayOfSizeK {

	public static void main(String[] args) {

		int a[] = { 1, 9, 0, 34, 2, 8 };
		//System.out.println(new _2MaxSumSubArrayOfSizeK().bruteForce(a, 3));

		//System.out.println(new _2MaxSumSubArrayOfSizeK().efficient(a, 3));

		System.out.println(new _2MaxSumSubArrayOfSizeK().anotherSlidingWindow(a, 3));

	}

	/**
	 * loop through all the sub arrays and find max sum
	 */
	public int bruteForce(int a[], int k) {
		int sum = 0;
		for (int i = 0; i < a.length - k+1; i++) {
			int localSum = 0;
			for (int j = i; j < i + 3; j++) {
				localSum += a[j];
			}
			sum = Math.max(sum, localSum);
		}
		return sum;

	}

	/**
	 * https://www.youtube.com/watch?v=EHCGAZBbB88&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj
	 * 
	 * In brute force we are doing some repetative work if we can avoid that
	 * repetative work then we can optimize this
	 * 
	 * when i = 0 j = 0, 1, 2 when i=1 j = 1,2,3 when i=2 j = 2,3,4
	 * 
	 * So in every step we are repeating last two digits we can avoid that if in
	 * every step we add the next element and delete previous one
	 * 
	 * using sliding window
	 * 
	 * 
	 * 
	 * Important:: HOW TO IDENTIFY IF WE CAN USE SLIDING WINDOW OR NOT
	 * 
	 * 1. if the questions given a string or array 
	 * 2. if it is demanding for sub string or sub array , because sub array/substring will be continuous and
	 * sliding window is continuous 
	 * 3. if it is demanding for min/max from the
	 * subarray or substring 
	 * 4. if there is an element k given which will be the
	 * window size Then sliding window will work
	 * 
	 */
	public int efficient(int a[], int k) {
		int i = 0;
		int sum = 0;
		for (int j = 0; j < k; j++) {
			sum += a[j];
		}
		int localSum = sum;
		for (int j = k; j < a.length; j++) {
			localSum = localSum + a[j] - a[i++];
			sum = Math.max(localSum, sum);
		}
		return sum;
	}

	/**
	 * Aditya verma solution
	 */
	public int anotherSlidingWindow(int a[], int k) {
		int i = 0;
		int j = 0;
		int sum = 0;
		int maxSum = 0;
		while (j < a.length) {
			sum += a[j];
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				maxSum = Math.max(sum, maxSum);
				sum = sum - a[i];
				i++;
				j++;
			}
		}
		return maxSum;
	}
}
