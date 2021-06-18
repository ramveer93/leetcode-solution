package leetcode.topinterview.questions;

/**
 * not easy: https://www.youtube.com/watch?v=wz00uI9mDXA
 * 
 * 
 * 
 * not easy: https://www.youtube.com/watch?v=KV-Eq3wYjxI
 * 
 * 
 * 
 * 
 * @author sramveer
 *
 */
public class _42TrappingRainWater {
	/**
	 * idea is to find out how much water a tower can trap : Min(leftMaxHeight,
	 * rightMaxHeight)-itsOwn height
	 * 
	 * 
	 * @return
	 */
	public int trapWater(int a[]) {
		int left = 0, right = a.length - 1;
		int res = 0;
		int lm = 0, rm = 0;
		while (left < right) {
			lm = Math.max(lm, a[left]);
			rm = Math.max(rm, a[right]);
			if (lm < rm) {

				res = res + lm - a[left];
				left++;
			} else {
				res = res + rm - a[right];
				right--;
			}
		}
		return res;

	}

	/**
	 * easy: https://www.youtube.com/watch?v=fTD6Se3ZtEo&feature=emb_title
	 * 
	 */
	public int trapWaterWithAnotherApproach(int a[]) {
		int res = 0;
		int left_max[] = new int[a.length];
		int right_max[] = new int[a.length];
		left_max[0] = a[0];
		right_max[a.length - 1] = a[a.length - 1];

		for (int i = 1; i < a.length; i++) {

			left_max[i] = Math.max(left_max[i - 1], a[i]);
		}

		for (int i = a.length - 2; i >= 0; i--) {

			right_max[i] = Math.max(right_max[i + 1], a[i]);
		}

		for (int i = 0; i < a.length; i++) {
			res = res + Math.min(left_max[i], right_max[i]) - a[i];

		}
		
		return res;
	}

}
