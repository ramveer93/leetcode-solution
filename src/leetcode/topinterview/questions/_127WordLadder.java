package leetcode.topinterview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _127WordLadder {
	public static void main(String[] args)
	{
		String wordList [] = {"hot","dot","dog","lot","log"};
		System.out.println(new _127WordLadder().ladderLength("hit","cog",Arrays.asList(wordList)));

	}

	/**
	 * https://www.youtube.com/watch?v=nVH5hyVSXa8
	 * 
	 * this is a graph problem , every node is connected with each other is it can
	 * be made by changing just one word But we dont know what is the next adjency
	 * node so we will try replacing all 26 chars one by one Graphh: shortest path
	 * -> bfs -> use queue
	 * 
	 */
	public int ladderLength(String startWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;

		}
		Map<String, Boolean> visited = new HashMap<>(); // this is to see if we have already visited the node or not
		for (String s : wordList) {
			visited.put(s, false);
		}
		Queue<String> q = new LinkedList<>();
		int length = 1;
		q.add(startWord);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String w = q.poll();
				if (w.equals(endWord)) {
					return length;
				}
				wordMatch(w, visited, q);

			}
			length++;

		}

		return 0;

	}

	public void wordMatch(String w, Map<String, Boolean> visited, Queue<String> q) {
		for (int i = 0; i < w.length(); i++) {
			char[] word = w.toCharArray();
			for (int j = 0; j < 26; j++) {
				char c = (char) ('a' + j);
				word[i] = c;
				String s = String.valueOf(word);
				if (visited.containsKey(s) && visited.get(s) == false) {
					q.add(s);
					visited.put(s, true);
				}

			}

		}

	}
}
