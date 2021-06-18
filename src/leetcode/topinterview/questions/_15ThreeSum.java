package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _15ThreeSum {
	public static void main(String[] args) {

	}

	/**
	 * NOT EFFICIENT
	 */
	public static int[] threeSum(int a[]) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				for (int k = 0; k < a.length; k++) {
					if (a[i] + a[j] + a[k] == 0) {
						List l = new ArrayList<>();
						l.add(a[i]);
						l.add(a[j]);
						l.add(a[k]);
						list.addAll(l);
					}
				}
			}
		}
		return list.stream().mapToInt(i -> i).toArray();
	}

	/**
	 * 
	 * sort the array 
	 * take three variables: i vary from 0 to n
	 * j will be next to i: j = i+1;
	 * k will be from end: k = n-1
	 * 
	 * now if sum  == 0 or sum == k then return i, j, kth element 
	 * if sum>0 or sum>k that means we have to remove some elements so k-- because k is largest element
	 * if sum<0 then we have to increse the sum , so j++ will increase the sum as array is sorted
	 */
	public static List<List<Integer>> getThreeSumWorking(int nums[]) {
		if (nums.length < 3)
			return new ArrayList<>(); // if nums less than 3 element
		Arrays.sort(nums); // sort array
		
		Set<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0)
					set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
				else if (sum > 0)
					k--;
				else if (sum < 0)
					j++;
			}

		}

		return new ArrayList<>(set);
	}

	/**
	 * https://www.youtube.com/watch?v=qJSPYnS35SE
	 * 
	 * @param a
	 * @return
	 */


}
