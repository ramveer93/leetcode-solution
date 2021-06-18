package otherthanleetcode;

import java.util.Arrays;

public class WaveFormSorting {

	public static void main(String[] args) {
		int a[] = { 3, 5, 1, 2, 6, 10, 7, 9, 8 };
		int t[] = new WaveFormSorting().waveSort(a);
		for (int i = 0; i < a.length; i++)
			System.out.println(t[i]);

	}

	/**
	 * https://www.youtube.com/watch?v=8oR5OBW5buk
	 */
	public int[] efficient(int a[], int n) {
		for (int i = 0; i < a.length - 1; i = i + 2) {
			if (i > 0 && a[i - 1] > a[i]) {
				swap(a, i, i - 1);
			}
			if (i < n - 1 && a[i] < a[i + 1]) {
				swap(a, i, i + 1);
			}
		}
		
		return a;

	}

	public int[] waveSortBySorting(int a[], int n) {
		Arrays.sort(a);

		for (int i = 0; i < n - 1; i = i + 2) {
			swap(a, i, i + 1);
		}

		return a;

	}

	/**
	 * https://www.youtube.com/watch?v=U_Jz-v4_Tms
	 */
	public int[] waveSort(int a[]) {
		for (int i = 0; i < a.length - 1; i++) {
			if (i % 2 == 0) {
				if (!(a[i] < a[i + 1])) {
					swap(a, i, i + 1);
				}
			} else if (i % 2 != 0) {
				if (!(a[i] > a[i + 1])) {
					swap(a, i, i + 1);
				}
			}
		}
		return a;
	}

	private void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
