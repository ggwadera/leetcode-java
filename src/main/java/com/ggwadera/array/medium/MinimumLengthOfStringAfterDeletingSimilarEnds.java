package com.ggwadera.array.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/">1750. Minimum Length of String After Deleting Similar Ends</a>
 */
public class MinimumLengthOfStringAfterDeletingSimilarEnds {

    /**
     * Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:
     * <ol>
     * <li>Pick a non-empty prefix from the string s where all the characters in the prefix are equal.</li>
     * <li>Pick a non-empty suffix from the string s where all the characters in this suffix are equal.</li>
     * <li>The prefix and the suffix should not intersect at any index.</li>
     * <li>The characters from the prefix and suffix must be the same.</li>
     * <li>Delete both the prefix and the suffix.</li>
     * </ol>
     * Return the minimum length of s after performing the above operation any number of times (possibly zero times).
     */
    public int minimumLength(String s) {
        final char[] chars = s.toCharArray();

        // Use a pointer at the start and other at the end of the string
        int l = 0;
        int r = chars.length - 1;

        // While the pointers are the same character and not overlap
        while (l < r && chars[l] == chars[r]) {
            char c = chars[l];
            // "Delete" from the left while it's the same character
            while (l < r && chars[l] == c) l++;
            // "Delete" from the right wile it's the same character
            while (r >= l && chars[r] == c) r--;
        }

        // Return the resulting length
        return r - l + 1;
    }

}
