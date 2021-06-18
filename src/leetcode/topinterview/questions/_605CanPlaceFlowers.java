package leetcode.topinterview.questions;

public class _605CanPlaceFlowers {

	public static void main(String[] args) {

		int a[] = { 1, 0, 0, 0, 1 };
		System.out.println(new _605CanPlaceFlowers().canPlaceFlowers(a, 1));
	}

	/**
	 * Can we plant n new flowers so that no adject flowers collide for water
	 * 
	 * The solution is very simple. We can find out the extra maximum number of
	 * flowers, countcount, that can be planted for the given flowerbedflowerbed
	 * arrangement. To do so, we can traverse over all the elements of the
	 * flowerbedflowerbed and find out those elements which are 0(implying an empty
	 * position). For every such element, we check if its both adjacent positions
	 * are also empty. If so, we can plant a flower at the current position without
	 * violating the no-adjacent-flowers-rule. For the first and last elements, we
	 * need not check the previous and the next adjacent positions respectively.
	 * 
	 * If the countcount obtained is greater than or equal to nn, the required
	 * number of flowers to be planted, we can plant nn flowers in the empty spaces,
	 * otherwise not.
	 * 
	 */
	public boolean canPlaceFlowers(int[] a, int n) {
		int count = 0;
		int i = 0;
		while (i < a.length) {
			// for ith position check if i and i-1 and i+1 are also 0 then plant a flower
			// here
			if (a[i] == 0 && (i == 0 || a[i - 1] == 0) && (i == a.length - 1 || a[i + 1] == 0)) {
				a[i] = i;
				count++;

			}
			i++;
		}
		return count >= n;

	}
}
