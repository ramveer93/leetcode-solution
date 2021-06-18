package leetcode.topinterview.questions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class _387FirstUniqueCharacterinaString {

	public static void main(String[] args) {
		System.out.println(new _387FirstUniqueCharacterinaString().firtUniqueCharInStr("leetcode"));
	}

	public int firtUniqueCharInStr(String s) {
	
		char res = 0;
		if (s == null || s.length() == 0)
			return -1;
		char a[] = s.toCharArray();
		int temp[] = new int[26];
		Map<Character,Integer> map = new LinkedHashMap<>();
		
		for (int i = 0; i < a.length; i++) {
			temp[a[i]-'a']++;
			map.put(a[i], map.getOrDefault(a[i], 0)+1);

		}
		for(java.util.Map.Entry<Character, Integer> e: map.entrySet()) {
			if(e.getValue() == 1) 
			{
				res = e.getKey();
				break;
				
			}
			
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] == res) {
				return i;

			}

		}
		
		return -1;

	}
	
	 public int firstUniqChar(String s) {
	        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
	        int n = s.length();
	        // build hash map : character and how often it appears
	        for (int i = 0; i < n; i++) {
	            char c = s.charAt(i);
	            count.put(c, count.getOrDefault(c, 0) + 1);
	        }
	        
	        // find the index
	        for (int i = 0; i < n; i++) {
	            if (count.get(s.charAt(i)) == 1) 
	                return i;
	        }
	        return -1;
	    }
	 
	 
}
