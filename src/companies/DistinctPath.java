package companies;

import java.util.HashMap;
import java.util.Map;

public class DistinctPath {
	public static void main(String[] args) {
		String s = "aa??aa";
		System.out.println(new DistinctPath().solve(s));
	}
	
	public String solve(String s) {
		Map<Character,Integer>map = new HashMap<>();
		int quest = 0;
		for(int i=0;i<s.length();i++) {
			char c= s.charAt(i);
			if(c=='?')quest++;
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		int a = map.get('a')==null?0:map.get('a');
		int b = map.get('b')==null?0:map.get('b');
		if(a==0) {
			a = quest;
		}else if(b==0) {
			b = quest;
			
		}
		
		StringBuffer sb = new StringBuffer();
		while(a>0 && b>0) {
			if(a>=2*b) {
				sb.append("aab");
				a -=2;
				b-=1;
				
			}else if(b>=2*a) {
				sb.append("bba");
				b-=2;
				a-=1;
				
			}else if(a>b) {
				sb.append("ab");
				b-=1;
				a-=1;
				
			}else {
				sb.append("ba");
				b-=1;
				a-=1;
			}
			
		}
		for(int i=0;i<a;i++) {
			sb.append("a");
		}
		for(int i=0;i<b;i++) {
			sb.append("b");
		}
		
		return sb.toString();
		
	}

	public String solution(String S) {
		if (S == null || S.length() == 0) {
			return S;
		}
		char prev = 'a';
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < S.length(); i++) {
			char current = S.charAt(i);
			if (current == '?') {
				current = (char) (prev + 1) >= 'z' ? 'a' : (char) (prev + 1);
				if (i < S.length() - 1 && S.charAt(i + 1) == current) {
					current = (char) (current + 1) >= 'z' ? 'a' : (char) (current + 1);

				}

			}
			prev = current;
			sb.append(prev);

		}
		return sb.toString();
	}

}
