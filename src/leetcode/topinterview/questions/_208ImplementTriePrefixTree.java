package leetcode.topinterview.questions;

/**
 * 
 * https://www.youtube.com/watch?v=T1M52UqQq3c
 * 
 * 
 * https://www.youtube.com/watch?v=6PX6wqDQE20
 * 
 * 
 * https://www.youtube.com/watch?v=0k79LqIaHyQ
 * 
 * 
 * 
 * 
 * @author sramveer
 *
 */
class TrieNode {
	TrieNode[] children = new TrieNode[26];
	boolean isEnd = false;
}

public class _208ImplementTriePrefixTree {

	TrieNode root;

	_208ImplementTriePrefixTree() {
		root = new TrieNode();
	}

	public void insert(String key) {
		TrieNode node = root;
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);
			int index = c - 'a';
			// first check if this char exists in trie or not
			if (node.children[index] == null) // that means it doesnt exists and we have to insert it to trie
			{
				node.children[index] = new TrieNode();

			}
			node = node.children[index]; // if the char exits then go to that node
		}
		node.isEnd = true;

	}

	public boolean search(String s) {
		TrieNode node = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = c - 'a';
			if (node.children[index] == null) {
				return false;

			}
			node = node.children[index];

		}
		return node.isEnd;

	}

	public boolean startsWith(String s) {
		TrieNode node = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = c - 'a';
			if (node.children[index] == null) {
				return false;

			}
			node = node.children[index];

		}
		return true;

	}

	public void delete(String s) {
		TrieNode node = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = c - 'a';
			if (node.children[index] == null) {
				return;
			}
			node = node.children[index];

		}
		node.isEnd = false;

	}

}
