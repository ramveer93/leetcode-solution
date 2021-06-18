package leetcode.topinterview.questions;

import java.util.Arrays;

public class _621TaskScheduler {

	/**
	 * https://www.youtube.com/watch?v=l6-y7MrHLB8&list=PLJtzaiEpVo2wrUwkvexbC-vbUqVIy7qC-&index=2&t=0s
	 * 
	 */
	public int leastInterval(char[] tasks, int n) {
		// frequencies of task
		int freq[] = new int[26];
		for (char c : tasks)
			freq[c - 'A']++;

		Arrays.sort(freq); // sorted in asc order of freq
		// now get max freq
		int maxFreq = freq[25];// last one will be max
		// calculate ideal time=(maxFreq-1)*n
		int idealTime = (maxFreq - 1) * n;

		for (int i = freq.length - 2; i >= 0 && idealTime > 0; i--) { // first access the most freq element so starting
																		// from last
			idealTime = idealTime - Math.min(maxFreq - 1, freq[i]);
		}

		idealTime = Math.max(0, idealTime);

		return idealTime + tasks.length;

	}
}
