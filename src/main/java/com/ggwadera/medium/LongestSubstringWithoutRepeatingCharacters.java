package com.ggwadera.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">3. Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        // This problem can be solved using the sliding window algorithm

        // Use a hash table to track the characters in the window
        int[] map = new int[128];

        // Use two pointers to move the sliding window
        int left = 0, right = 0;

        // Variable to hold the max value found
        int longest = 0;

        // Variable to count the number of duplicates inside the window
        int duplicates = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            // If the character is already in the window, increase the counter
            if (map[c] > 0) duplicates++;
            map[c] += 1;
            right += 1;

            // Loop until there's no more duplicates in the window
            while (duplicates > 0) {
                // Move the left pointer until finding the first non-repeating character
                char duplicate = s.charAt(left);
                if (map[duplicate] > 1) duplicates--;
                map[duplicate] -= 1;
                left += 1;
            }

            // Calculate the max value from the right and left window positions
            longest = Math.max(longest, right - left);
        }
        return longest;
    }

}
