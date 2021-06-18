package adityaverma.slidingwinndow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurancesOfAnagram {

	public static void main(String[] args) {
		String text = "abcxdcbakhbacklbbac";
		String pattern = "abc";
		System.out.println(new CountOccurancesOfAnagram().countAnagrams(text, pattern));
	}

	public int countAnagrams(String text, String pattern) {
		int ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : pattern.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);
		int count = map.size();
		int i = 0, j = 0;
		int k = pattern.length();

		while (j < text.length()) {
			// calculation
			char c = text.charAt(j);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
			}
			if (map.get(c) != null && map.get(c) == 0) {
				count--;
			}
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				// collect the answer
				if (count == 0) {
					ans++;
					System.out.println(text.substring(i, j + 1));
				}
				// slide the window
				char temp = text.charAt(i);
				if (map.containsKey(temp)) {
					map.put(temp, map.get(temp) + 1);
				}
				if (map.get(temp) != null && map.get(temp) == 1) {
					count++;
				}
				i++;
				j++;
			}
		}
		return ans;
	}
}
