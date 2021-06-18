package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class _451SortCharactersByFrequency {

	public static void main(String[] args) {

		System.out.println(new _451SortCharactersByFrequency().frequencySort("Aabb"));
	}

	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		List<Entry<Character, Integer>> entriesList = new ArrayList<>(entrySet);
		Collections.sort(entriesList, new Comparator<Entry<Character, Integer>>() {
			public int compare(Entry<Character, Integer> e1, Entry<Character, Integer> e2) {
				return e2.getValue().compareTo(e1.getValue());
			}
		});
		StringBuffer sb = new StringBuffer();

		for (Entry<Character, Integer> e : entriesList) {
			for (int i = 0; i < e.getValue(); i++) {
				sb.append(e.getKey());
			}
		}

		return sb.toString();

	}
	
	
	
	
	
	
	
}
