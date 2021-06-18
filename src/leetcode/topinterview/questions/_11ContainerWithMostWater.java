package leetcode.topinterview.questions;

/**
 * 
 * 
 * @author sramveer
 *
 */
public class _11ContainerWithMostWater {
	public static void main(String[] args) {

	}

	/**
	 * two pointer approach 
	 * https://www.youtube.com/watch?v=K8SF4YadH0Q
	 */
	public int maxArea(int[] height) {
		int maxArea = 0, left = 0, right = height.length - 1;
		if (height.length == 1) {
			return 0;
		}
		while (left < right) {
			int minOfHeight = Math.min(height[left], height[right]);
			int distance = right - left;
			int area = minOfHeight * distance;
			maxArea = Math.max(maxArea, area);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;

	}
}
