package com.ggwadera.string.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/length-of-last-word/">58. Length of Last Word</a>
 */
public class LengthOfLastWord {

    /**
     * Given a string s consisting of words and spaces, return the length of the last word in the string.
     * A word is a maximal substring consisting of non-space characters only.
     */
    public int lengthOfLastWord(String s) {
        final char[] chars = s.toCharArray();
        int i = s.length() - 1;
        int length = 0;
        while (i >= 0 && chars[i] == ' ') i--;
        while (i >= 0 && chars[i] != ' ') {
            length++;
            i--;
        }
        return length;
    }

}
