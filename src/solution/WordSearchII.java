package solution;

import java.util.LinkedList;
import java.util.*;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" 
 * cells are those horizontally or vertically neighboring. The same letter cell may not be 
 * used more than once in a word.
 * 
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 * 
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * Return ["eat","oath"].
 * 
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @author Dongliang Yu
 *
 */
public class WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> ret = new LinkedList<String>();
		Set<String> set = new HashSet<String>();
		int m = board.length;
		if (m == 0) return ret;
		int n = board[0].length;
		if (n == 0) return ret;
		boolean[][] visited = new boolean[m][n];
		Trie dict = new Trie();
		for (String w : words)
			dict.insert(w);
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				find(board, dict, visited, i, j, new StringBuilder(), set);
		for (String s : set)
			ret.add(s);
		return ret;
	}

	private void find(char[][] board, Trie dict, boolean[][] visited, int x,
			int y, StringBuilder curr, Set<String> set) {
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
		if (visited[x][y]) return;
		visited[x][y] = true;
		curr.append(board[x][y]);
		String s = curr.toString();
		if (dict.startsWith(s)) { // is prefix
			if (dict.search(s)) // found in the dict
				set.add(s);
			find(board, dict, visited, x + 1, y, curr, set);
			find(board, dict, visited, x - 1, y, curr, set);
			find(board, dict, visited, x, y + 1, curr, set);
			find(board, dict, visited, x, y - 1, curr, set);
		}
		curr.deleteCharAt(curr.length() - 1);
		visited[x][y] = false;
	}
}
