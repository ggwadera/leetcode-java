package com.ggwadera.trie.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/design-add-and-search-words-data-structure">211. Design Add and Search Words Data Structure</a>
 */
public class WordDictionary {

    private static final class TrieNode {
        final TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds word to the data structure, it can be matched later.
     */
    public void addWord(String word) {
        var node = root;
        for (char c : word.toCharArray()) {
            int k = c - 'a';
            if (node.children[k] == null) {
                node.children[k] = new TrieNode();
            }
            node = node.children[k];
        }
        node.isWord = true;
    }

    /**
     * Returns true if there is any string in the data structure that matches word or false otherwise.
     * word may contain dots '.' where dots can be matched with any letter.
     */
    public boolean search(String word) {
        return search(word, 0, root);
    }

    /**
     * Search for a prefix in the trie. For '.' characters, start a DFS on the current node children, looking for the
     * remaining characters of the string.
     */
    private boolean search(String word, int i, TrieNode node) {
        if (i == word.length()) return node.isWord;
        char c = word.charAt(i);
        if (c == '.') {
            for (var child : node.children) {
                if (child != null && search(word, i + 1, child))
                    return true;
            }
        } else {
            var child = node.children[c - 'a'];
            return child != null && search(word, i + 1, child);
        }
        return false;
    }
}
