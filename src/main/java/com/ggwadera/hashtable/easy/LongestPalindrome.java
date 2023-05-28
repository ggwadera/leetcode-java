package com.ggwadera.hashtable.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/longest-palindrome">409. Longest Palindrome</a>
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        // Count every character in the string
        int[] frequencies = new int[128]; // O(1) space complexity (constant)
        for (char c : s.toCharArray()) frequencies[c]++;

        int result = 0;
        for (int frequency : frequencies) {
            // Sum up every possible pair combination (like "aa", "bbbb", "[cccc]c", ...)
            result += frequency / 2 * 2;
        }

        // If the possible length is less than the original string, there are still some characters remaining
        // So add one more, this would be the character in the middle of the palindrome.
        if (result < s.length()) result++;

        return result;
    }
}
