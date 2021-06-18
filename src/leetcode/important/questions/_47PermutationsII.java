package leetcode.important.questions;

import java.util.ArrayList;
import java.util.List;

public class _47PermutationsII {

	public static void main(String[] args) {

		int a[] = {1,1,2};
		System.out.println(new _47PermutationsII().permutations(a).toString());
	}

	public List<List<Integer>> permutations(int a[]) {

		List<List<Integer>> res = new ArrayList<>();
		boolean used[] = new boolean[a.length];
		helper(res, a, used, new ArrayList<>());
		return res;
	}

	private void helper(List<List<Integer>> res, int[] a, boolean[] used, List<Integer> current) {
		if (current.size() == a.length) {
			res.add(new ArrayList<>(current));
			return;
		}
		for (int i = 0; i < a.length; i++) {
			if (used[i])
				continue;
			if (i > 0 && a[i] == a[i - 1] && !used[i - 1])
				continue;
			current.add(a[i]);
			used[i] = true;
			helper(res, a, used, current);
			current.remove(current.size() - 1);
			used[i] = false;
		}

	}

}
