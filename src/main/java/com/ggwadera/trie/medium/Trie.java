package com.ggwadera.trie.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/implement-trie-prefix-tree">208. Implement Trie (Prefix Tree)</a>
 */
public class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Inserts the string word into the trie.
     * @param word
     */
    public void insert(String word) {
        var node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.contains(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.terminates = true;
    }

    /**
     * Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
     * @param word
     * @return
     */
    public boolean search(String word) {
        var node = searchPrefix(word);
        return node != null && node.terminates;
    }

    /**
     * Returns true if there is a previously inserted string word that has the prefix, and false otherwise.
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String word) {
        var node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.contains(c)) {
                node = node.get(c);
            } else {
                return null;
            }
        }
        return node;
    }

    private static class TrieNode {

        private final static int R = 26; // 26 characters

        final TrieNode[] children;
        boolean terminates = false;

        TrieNode() {
            this.children = new TrieNode[R];
        }

        boolean contains(char c) {
            return children[c - 'a'] != null;
        }

        TrieNode get(char c) {
            return children[c - 'a'];
        }

        void put(char c, TrieNode node) {
            children[c - 'a'] = node;
        }
    }
}
