package leetcode.topinterview.questions;

import java.util.HashMap;
import java.util.Map;

public class _169MajorityElement {
	public static void main(String[] args) {
		int a[] = { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println(new _169MajorityElement().majorityElement(a));
	}

	public int majorityElement(int a[]) {
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (hm.containsKey(a[i])) {
				hm.put(a[i], hm.get(a[i]) + 1);
			} else {
				hm.put(a[i], 1);
			}
		}
		for (java.util.Map.Entry<Integer, Integer> e : hm.entrySet()) {
			if (e.getValue() > a.length / 2) {
				return e.getKey();

			}

		}
		return -1;

	}

}
