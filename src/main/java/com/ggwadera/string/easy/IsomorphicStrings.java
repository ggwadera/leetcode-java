package com.ggwadera.string.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/isomorphic-strings/">205. Isomorphic Strings</a>
 */
public class IsomorphicStrings {

    /**
     * Given two strings s and t, determine if they are isomorphic.
     * <p>
     * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
     * <p>
     * All occurrences of a character must be replaced with another character while preserving the order of characters.
     * No two characters may map to the same character, but a character may map to itself.
     */
    public boolean isIsomorphic(String s, String t) {
        final int[] sMap = new int[128];
        final int[] tMap = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sMap[sChar] != tMap[tChar]) {
                return false;
            }
            sMap[sChar] = i + 1;
            tMap[tChar] = i + 1;
        }
        return true;
    }

}
