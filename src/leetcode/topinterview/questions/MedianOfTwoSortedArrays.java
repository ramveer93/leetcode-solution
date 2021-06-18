package leetcode.topinterview.questions;

public class MedianOfTwoSortedArrays {

	public double getMedian(int num1[], int num2[]) {
		int i = 0, j = 0, m1 = 0, m2 = 0, p = 0;
		m1 = num1.length;
		m2 = num2.length;
		int k[] = new int[m1 + m2];
		while (i < m1 && j < m2) {
			if (num1[i] < num2[j]) {
				k[p++] = num1[i++];
			} else {
				k[p++] = num2[j++];
			}

		}
		while (i < m1) {
			k[p++] = num1[i++];
		}

		while (j < m2) {
			k[p++] = num2[j++];
		}
		return getMedian(k);

	}

	public double getMedian(int a[]) {
		double res;
		int n = a.length;

		if (a.length % 2 == 0) {

			res = (double) (a[n / 2] + a[(n / 2) - 1]) / 2;
		} else {
			res = a[n / 2];
		}
		return res;
	}

}
