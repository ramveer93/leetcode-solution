package adityaverma.slidingwinndow.variablesize;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _3LongestSubstrWithAllUniqueChars {

	public static void main(String[] args) {
		String s = "GEEKSFORGEEKS";
		//System.out.println(new _3LongestSubstrWithAllUniqueChars().longestSubstrWRONG(s));
		System.out.println(new _3LongestSubstrWithAllUniqueChars().efficient(s));

	
	}

	
	/**
	 * We can use set instead of map
	 * @return
	 */
	public int efficient(String s) {
		int i=0;
		int j=0;
		int max = 0;
		Set<Character>set = new HashSet<>();
		String res = "";
		
		while(j<s.length()) {
			if(set.contains(s.charAt(j))) {
				set.remove(s.charAt(i));
				i++;
			}else {
				set.add(s.charAt(j));
				max = Math.max(max, set.size());
				if(res.length()<s.substring(i, j+1).length()) {
					res = s.substring(i, j+1);
				}
			    j++;
			}
		}
		System.out.println(res);
		return max;
	}
	/**
	 * This is similar to _2 problem in previous problem ask was longest sub str
	 * with k unique chars but here it is longest substr with all unique characters
	 * 
	 * K is not given here , but since it is longest substring with all unique chars
	 * so k will be window size =j-1+1
	 * 
	 * No other changes
	 */
	public int longestSubstrWRONG(String s) {
		int i = 0;
		int j = 0;
		int max = 0;
		int k = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (j < s.length()) {
			map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
			k = j-i+1;
			if (map.size() < k) {
				j++;
			} else if (map.size() == k) {
				max = Math.max(max, k);
				System.out.println(s.substring(i, j + 1));
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
		return max;
	}
}
