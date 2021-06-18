package leetcode.topinterview.questions;

import java.util.HashMap;
import java.util.Map;

public class _Athena {

	public static void main(String[] args) {

		System.out.println(new _Athena().encode(440489889));
	}

	public String encode(int n) {
		Map<Integer, Character> map = new HashMap<>();

		map.put(0, 'A');
		map.put(1, 'T');
		map.put(2, 'H');
		map.put(3, 'E');
		map.put(4, 'N');
		map.put(5, 'S');

		StringBuilder sb = new StringBuilder();
		if(n<6)return String.valueOf(map.get(n));

		while (n > 0) {
			sb.append(map.get(n % 6));
			n = n / 6;

		}
		return sb.toString();

	}
}
