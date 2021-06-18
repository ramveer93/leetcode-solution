package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {

	public static void main(String[] args) {
		String[] s = { "eat" };
		System.out.println(new GroupAnagrams49().groupAnagrams(s).toString());

	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if (strs.length == 0 || strs == null)
			return res;
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char r[] = s.toCharArray();
			Arrays.sort(r);
			String key = new String(r);

			List<String> tempList = new ArrayList<>();

			if (map.containsKey(key)) {
				tempList = map.get(key);
				tempList.add(s);
				map.put(key, tempList);
			} else {
				tempList.add(s);
				map.put(key, tempList);
			}

		}

		for (java.util.Map.Entry<String, List<String>> e : map.entrySet()) {
			res.add(e.getValue());
		}

		return res;

	}

}
