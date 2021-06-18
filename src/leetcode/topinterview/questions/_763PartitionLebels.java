package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

public class _763PartitionLebels {
	public static void main(String[] args) {
		System.out.println(new _763PartitionLebels().partitionLebels("ababcbacadefegdehijhklij"));
	}

	/**
	 * https://www.youtube.com/watch?v=kS4P0vXbGmc
	 * 
	 * 
	 * https://www.youtube.com/watch?v=5NCjHqx2v-k
	 * 
	 */
	public List<Integer> partitionLebels(String s) {

		List<Integer> res = new ArrayList<>();

		int lastOccurance[] = new int[26];

		for (int i = 0; i < s.length(); i++)
			lastOccurance[s.charAt(i) - 'a'] = i;
		int start = 0;
		int end = 0;

		for (int i = 0; i < s.length(); i++) {
			end = Math.max(end, lastOccurance[s.charAt(i)-'a']);
			if (i == end) {
				res.add(end - start + 1);// length
				start = end + 1;
			}

		}

		return res;

	}
}
