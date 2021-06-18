package athenahealth;

import java.util.Arrays;
import java.util.Collections;

/**
 * Alex is given n piles of boxes of equal or unequal heights. In one step, Alex
 * can remove any number of boxes from the pile which has the maximum height and
 * try to make it equal to the one which is just lower than the maximum height
 * of the stack. Determine the minimum number of steps required to make all of
 * the piles equal in height. Example n = 3 boxesInPiles = [ 5, 2, 1 ] In the
 * first step, remove 3 boxes from boxesInPiles[0], and the new array is
 * boxesInPiles' = [2, 2, 1]. Now reduce the two taller piles by 1 box each to
 * match the height of the shortest pile. This takes 2 steps because each step
 * is performed on only one pile. The final number of steps required is 3.
 *
 */
public class Piles {

	public static void main(String[] args) {
		Integer[] a = { 5, 2, 1 };
		System.out.println(new Piles().minSteps(a));

	}

	public int minSteps(Integer a[]) {
		Arrays.sort(a, Collections.reverseOrder());
		int count = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				count += i;
			}
		}
		return count;

	}

}
