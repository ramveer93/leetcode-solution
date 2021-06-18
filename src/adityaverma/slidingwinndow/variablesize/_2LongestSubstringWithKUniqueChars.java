package adityaverma.slidingwinndow.variablesize;

import java.util.HashMap;
import java.util.Map;

public class _2LongestSubstringWithKUniqueChars {

	public static void main(String[] args) {
		String s = "aaabbbm";
		int k = 2;
		System.out.println(
				new _2LongestSubstringWithKUniqueChars().longestSubstrWithKUniqueChars(s, k));
	}

	public int longestSubstrWithKUniqueChars(String s, int k) {
		int i = 0;
		int j = 0;
		Map<Character, Integer> map = new HashMap<>();
		int ans = 0;
		while (j < s.length()) {
			map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
			if (map.size() < k) {
				j++;
			} else if (map.size() == k) {
				ans = Math.max(j - i + 1, ans);
				System.out.println(s.substring(i,j+1));
				j++;
			} else if (map.size() > k) {
				while (map.size() > k) {
					if (map.containsKey(s.charAt(i))) {
						map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
					}
					if (map.get(s.charAt(i)) == 0) {
						map.remove(s.charAt(i));
					}
					i++;
				}
				j++;
			}
		}
		return ans;
	}
}
