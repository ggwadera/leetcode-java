package com.ggwadera.trie.medium;

import java.util.List;

/**
 * Solution for <a href="https://leetcode.com/problems/word-break">139. Word Break</a>
 */
public class WordBreak {

    /**
     * Given a string s and a dictionary of strings wordDict,
     * return true if s can be segmented into a space-separated sequence of one or more dictionary words.
     * <p>
     * Note that the same word in the dictionary may be reused multiple times in the segmentation.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        TrieNode root = new TrieNode(wordDict);

        // Dynamic Programming + Trie approach
        // Use a boolean array to keep track of complete words
        // N + 1 to handle the edge case at the of string more nicely
        boolean[] dp = new boolean[n + 1];

        // Set the last position to true (n = just after the string ends)
        dp[n] = true;

        // Start from the end of the string and backtrack until the start
        for (int i = n - 1; i >= 0; i--) {
            var node = root;

            // For each character, try to build a complete word using the trie
            for (int j = i + 1; j <= n; j++) {
                char c = s.charAt(j - 1);
                var child = node.get(c);
                if (child == null) break;
                node = child;

                // If completed a word, check if it ended where another word starts
                if (node.isWord && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    private static final class TrieNode {

        final TrieNode[] children = new TrieNode[26];
        boolean isWord;

        TrieNode() {}

        TrieNode(Iterable<String> words) {
            for (var word : words) {
                addWord(word);
            }
        }

        public void addWord(String word) {
            var node = this;
            for (char c : word.toCharArray()) {
                var child = node.get(c);
                if (child == null) {
                    child = node.put(c, new TrieNode());
                }
                node = child;
            }
            node.isWord = true;
        }

        private TrieNode get(char c) {
            return children[c - 'a'];
        }

        private TrieNode put(char c, TrieNode node) {
            children[c - 'a'] = node;
            return node;
        }
    }
}
