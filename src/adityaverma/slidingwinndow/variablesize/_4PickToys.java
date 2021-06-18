package adityaverma.slidingwinndow.variablesize;

import java.util.HashMap;
import java.util.Map;

public class _4PickToys {

	public static void main(String[] args) {
		String s = "aabbcc";
		int k = 2;
		System.out.println(new _4PickToys().pickToys(s, k));
	}
	
	/**
	 * longest substring with Atmost 2 distinct items/toys
	 * 
	 * a kid can choose toys but two conditions:
	 * 
	 * 1. boy has to pick toys one by one : substring
	 * 2. there should be at most two types of toys: atmost 2 distinct chars
	 */
	public int pickToys(String s, int k ) {
		int i=0;
		int j=0;
		int max = 0;
		Map<Character,Integer>map = new HashMap<>();
		while(j<s.length()) {
			map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
			if(map.size()<k) {
				j++;
			}else if(map.size() == k) {
				max = Math.max(max, j-i+1);
				System.out.println(s.substring(i,j+1));
				j++;
			}else if(map.size()>k) {
				while(map.size()>k) {
					if(map.containsKey(s.charAt(i))) {
						map.put(s.charAt(i), map.get(s.charAt(i))-1);
					}
					if(map.get(s.charAt(i))==0) {
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
