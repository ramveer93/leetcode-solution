package adityaverma.slidingwinndow.variablesize;

import java.time.temporal.TemporalUnit;

public class _1FormatVariableSizeWindow {

	public int variableSizeWindow(int a[], int k) {
		// k will be condition , i.e find max length of subarray which has
		// sum equal to k

		int i = 0;
		int j = 0;
		int tempSum = 0;
		int ans = 0;

		while (j < a.length) {
			tempSum += a[j];
			if (tempSum < k) {
				j++;
			} else if (tempSum == k) {
				// collect the ans
				ans = Math.max(j - i + 1, ans);
				j++;
			} else if (tempSum > k) {
				while (tempSum > k) {
					tempSum = tempSum - a[i];
					i++;
				}
				j++;
			}
		}
		return ans;
	}
}
