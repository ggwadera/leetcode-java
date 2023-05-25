package com.ggwadera.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string">28. Find the Index of the First Occurrence in a String</a>
 */
public class FindIndexOfStringFirstOccurrence {

    /**
     * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
     * or -1 if needle is not part of haystack.
     */
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();

        if (m < n) return -1;

        for (int j = 0; j <= m - n; j++) {
            for (int i = 0; i < n; i++) {
                if (needle.charAt(i) != haystack.charAt(j + i)) {
                    break;
                }
                if (i == n - 1) return j;
            }
        }

        return -1;
    }
}
