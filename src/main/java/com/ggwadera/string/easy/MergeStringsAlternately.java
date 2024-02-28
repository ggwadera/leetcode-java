package com.ggwadera.string.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/merge-strings-alternately">1768. Merge Strings Alternately</a>
 */
public class MergeStringsAlternately {

    /**
     * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
     * starting with word1.
     * If a string is longer than the other, append the additional letters onto the end of the merged string.
     * Return the merged string.
     */
    public String mergeAlternately(String word1, String word2) {
        var sb = new StringBuilder();
        int n = word1.length();
        int m = word2.length();
        int i = 0;
        while (i < n && i < m) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        if (i < n) {
            sb.append(word1.substring(i));
        } else if (i < m) {
            sb.append(word2.substring(i));
        }
        return sb.toString();
    }

}
