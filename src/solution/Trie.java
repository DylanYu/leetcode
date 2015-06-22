package solution;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @author Dongliang Yu
 *
 */
class TrieNode {
    private int R = 26;
    boolean isWord;
    TrieNode[] next;
    // Initialize your data structure here.
    public TrieNode() {
        isWord = false;
        next = new TrieNode[R];
    }
}

public class Trie {
    private TrieNode root;
    private char base = 'a';

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null) return;
        if (word.length() == 0) { // empty string
        	root.isWord = true;
        	return;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.next[c-base] == null)
                node.next[c-base] = new TrieNode();
            if (i == word.length()-1)
                node.next[c-base].isWord = true;
            node = node.next[c-base];
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        if (word == null) return false;
        if (word.length() == 0) return root.isWord;  // empty string
        char[] c = word.toCharArray();
        for (int i = 0; i < c.length; i++) {
            node = node.next[c[i]-base];
            if (node == null) return false;
        }
        return node.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        char[] c = prefix.toCharArray();
        for (int i = 0; i < c.length; i++) {
            node = node.next[c[i]-base];
            if (node == null) return false;
        }
        return node != null; // capable of handling empty string
    }
}
