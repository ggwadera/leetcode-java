package com.ggwadera.trie.medium;

import java.util.List;
import java.util.StringJoiner;

/**
 * Solution for <a href="https://leetcode.com/problems/replace-words">648. Replace Words</a>
 */
public class ReplaceWords {

    /**
     * In English, we have a concept called root, which can be followed by some
     * other word to form another longer word - let's call this word successor.
     * For example, when the root "an" is followed by the successor word "other", we can form a new word "another".
     * <p>
     * Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces,
     * replace all the successors in the sentence with the root forming it.
     * If a successor can be replaced by more than one root, replace it with the root that has the shortest length.
     * <p>
     * Return the sentence after the replacement.
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode trie = new TrieNode(dictionary);
        var sj = new StringJoiner(" ");
        for (String word : sentence.split(" ")) {
            sj.add(trie.findFirstPrefix(word));
        }
        return sj.toString();
    }

    private static final class TrieNode {

        final TrieNode[] children = new TrieNode[26];
        String word;

        TrieNode() {}

        TrieNode(Iterable<String> words) {
            for (var word : words) {
                addWord(word);
            }
        }

        /**
         * Add the word to the trie, if there's no shorter prefix already present
         */
        public void addWord(String word) {
            var node = this;
            for (char c : word.toCharArray()) {
                var child = node.get(c);
                if (child == null) {
                    child = node.put(c, new TrieNode());
                } else if (child.word != null) {
                    // there's already a shorter prefix
                    // no need to add this word
                    return;
                }
                node = child;
            }
            node.word = word;
        }

        /**
         * Find the shortest prefix for the given word, if not found, returns the same word.
         */
        public String findFirstPrefix(String word) {
            var node = this;
            for (char c : word.toCharArray()) {
                var child = node.get(c);
                if (child == null) {
                    return word;
                }
                if (child.word != null) return child.word;
                node = child;
            }
            return word;
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
