package leetcode.topinterview.questions;

public class _162FindPeak {
	public static void main(String[] args) {
		int a[] = { 1, 2, 1, 3, 5, 6, 4 };
		System.out.println(new _162FindPeak().peakLinear(a));
	}

	/**
	 * if a[mid]>a[mid+1] (falling slop), then peak will be in left side if
	 * a[mid]<a[mid+1] (growing slop), then peak will be in right side
	 * 
	 * also if we have a incomplete peak then move to that direction
	 * 
	 * 5, 10 => lets say a[mid] = 5, a[mid+1] = 10 so we have half peak , complete
	 * this to move to right side
	 * 
	 */
	public int peak(int a[]) {
		int l = 0, r = a.length - 1;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (a[mid] > a[mid + 1]) {
				r = mid ;

			} else {
				l = mid + 1;
			}

		}

		return l;

	}

	public int peakLinear(int a[]) {
		for (int i = 0; i < a.length - 2; i++) {
			if (a[i] < a[i + 1] && a[i + 1] > a[i + 2]) {
				return i + 1;
			}
		}
		return -1;

	}

}
