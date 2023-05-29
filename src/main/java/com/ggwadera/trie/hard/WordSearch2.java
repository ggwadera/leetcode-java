package com.ggwadera.trie.hard;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {

    private final TrieNode root = new TrieNode();
    private int m, n;
    private char[][] board;

    /**
     * Given an m x n board of characters and a list of strings words, return all words on the board.
     * <p>
     * Each word must be constructed from letters of sequentially adjacent cells,
     * where adjacent cells are horizontally or vertically neighboring.
     * The same letter cell may not be used more than once in a word.
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> found = new ArrayList<>();

        // Build a trie with all the words to search
        root.addWords(words);

        m = board.length;
        n = board[0].length;
        this.board = board;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // For every letter of the board, start a DFS, checking if any combinations are in the trie
                dfs(i, j, found, root);
            }
        }

        return found;
    }

    private void dfs(int i, int j, List<String> found, TrieNode node) {
        char c = board[i][j];
        if (c == '#') return; // visited node

        node = node.get(c); // search down the trie
        if (node == null) {
            // if there's no children for this character, end the search
            return;
        } else if (node.word != null) {
            // if there's a children, check if it's a complete word, then add to the result
            found.add(node.word);
            node.word = null;
        }

        board[i][j] = '#'; // mark as visited
        if (i < m - 1) dfs(i + 1, j, found, node); // search down
        if (i > 0) dfs(i - 1, j, found, node);     // search up
        if (j < n - 1)dfs(i, j + 1, found, node);  // search right
        if (j > 0) dfs(i, j - 1, found, node);     // search left
        board[i][j] = c; // restore to the original char
    }

    private static final class TrieNode {

        final TrieNode[] children = new TrieNode[26];
        String word;

        public void addWords(String[] words) {
            for (var word : words) {
                var node = this;
                for (char c : word.toCharArray()) {
                    var child = node.get(c);
                    if (child == null) {
                        child = new TrieNode();
                        node.put(c, child);
                    }
                    node = child;
                }
                node.word = word;
            }
        }

        private TrieNode get(char c) {
            return children[c - 'a'];
        }

        private void put(char c, TrieNode node) {
            children[c - 'a'] = node;
        }
    }
}
