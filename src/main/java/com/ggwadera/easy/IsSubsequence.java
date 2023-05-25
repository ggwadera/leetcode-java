package com.ggwadera.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/is-subsequence">392. Is Subsequence</a>
 */
public class IsSubsequence {

    /**
     * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
     * <p>
     * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
     * of the characters without disturbing the relative positions of the remaining characters.
     * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
     */
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0;
        for (int j = 0; j < m && i < n; j++) {
            if (s.charAt(i) == t.charAt(j)) i++;
        }
        return i == n;
    }

}
