package adityaverma.slidingwinndow.variablesize;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayOfSumK {

	public static void main(String[] args) {
		//int a[] = { 4, 1, 1, 1, 2, 3, 5 };
		int a[] = {-5, 8, -14, 2, 4, 12};
		//int a[] = {1,2,3};
		//System.out.println(new LargestSubArrayOfSumK().solve(a, -5));
		System.out.println(new LargestSubArrayOfSumK().efficient(a, -5));
	}

	/**
	 * a: 4,1,1,1,2,3,5 sum: 5 find largest sub array which has sum as 5
	 * 
	 * this wont work for negative nos
	 * 
	 */
	public int solve(int a[], int sum) {
		int i = 0;
		int j = 0;
		int maxSize = 0;
		int tempSum = 0;

		while (j < a.length && i < a.length) {
			tempSum += a[j];
			if (tempSum < sum) {
				// j++;
			} else if (tempSum == sum) {
				maxSize = Math.max(maxSize, j - i + 1);
				// j++;
			} else if (tempSum > sum) {
				while (tempSum > sum) {
					tempSum -= a[i];
					i++;
				}

			}
			j++;

		}
		return maxSize;
	}

	//-5 8 -14 2 4 12
	public int efficient(int a[], int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int maxLeng = 0;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (sum == k) {
				maxLeng = i + 1;
				System.out.println("array found");
			}
			if (!map.containsKey(sum))
				map.put(sum, i);
			if (map.containsKey(sum - k)) {
				maxLeng = Math.max(maxLeng, i - map.get(sum - k));
				System.out.println("array found22");
			}
		}
		return maxLeng;
	}
}
