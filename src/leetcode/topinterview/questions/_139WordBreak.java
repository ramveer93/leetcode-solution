package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.List;

public class _139WordBreak {

	public static void main(String[] args) {
		String word = "catsanddog";
		List<String> l = new ArrayList<>();
		l.add("cats");
		l.add("dog");
		l.add("sand");
		l.add("and");
		l.add("cat");

		System.out.println(new _139WordBreak().wordBreak(word, l));
	}

	/**
	 * 
	 * https://www.youtube.com/watch?v=YxtQUbKbdUs
	 *  dp[0] = true; // empty string can
	 * be fragmented with any dictionary dp[i] = > denotes , if a word with
	 * s.substring(0,i) can be segmented into words from dictionary
	 * 
	 * if dp[i] = true: two cases 
	 *    a. either 0 to i is word which exists in dict
	 *    b. or dp[k] where k is immediately index less than i where dp[k] is true, so s.substring(k,i) is exists in dict
	 */
	public boolean wordBreak(String word, List<String> wordDict) {
		boolean dp[] = new boolean[word.length() + 1];
		dp[0] = true; // because empty string will alway be part of any dict
		for (int i = 1; i <= word.length(); i++) // i = 1 because we already have dp[0] assigned
		{
			for (int j = 0; j < i; j++) // j = 0 because j should always be less than i
			{
				String w = word.substring(j, i);
				if (dp[j] && wordDict.contains(word.substring(j, i))) {
					dp[i] = true;
					System.out.println(w);
					break;
				}
			}
		}
		
		return dp[word.length()];

	}

}
