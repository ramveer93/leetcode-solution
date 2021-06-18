package adityaverma.slidingwinndow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeNumberInEveryWindowSizeK {

	public static void main(String[] args) {
		int a[] = { 2, -1, -7, 8, -15, 30, 16, 28 };

		new FirstNegativeNumberInEveryWindowSizeK().firstNegativeBruteForce(a, 3);
		new FirstNegativeNumberInEveryWindowSizeK().efficient(a, 3);

	}

	/**
	 * Efficient approach 
	 * 
	 */
	public void efficient(int a[], int k) {
		int i = 0;
		int j = 0;
		List<Integer> list = new ArrayList<>();

		while (j < a.length) {
			// calculation
			if (a[j] < 0) {
				list.add(a[j]);
			}
			if (j - i + 1 < k) {
				j++;
				continue;
			} else if (j - i + 1 == k) {
				// get an answer
				if (list.size() == 0) {
					System.out.println(0);
				} else {
					System.out.println(list.get(0));
					if (a[i] == list.get(0)) {
						list.remove(0);
					}
				}
				i++;
				j++;
			}
		}
	}

	public void firstNegativeBruteForce(int a[], int k) {
		int i = 0;
		int j = 0;
		while (j < a.length) {
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				for (int t = i; t <= j; t++) {
					if (a[t] < 0) {
						System.out.println(a[t]);
						break;
					} else if (a[t] > 0 && t == j) {
						System.out.println(0);
						break;
					}
				}
				j++;
				i++;
			}

		}

	}
}
