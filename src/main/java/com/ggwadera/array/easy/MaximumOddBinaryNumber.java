package com.ggwadera.array.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/maximum-odd-binary-number/">2864. Maximum Odd Binary Number</a>
 */
public class MaximumOddBinaryNumber {

    /**
     * You are given a binary string s that contains at least one '1'.
     * You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number that can be created from this combination.
     * <p>
     * Return a string representing the maximum odd binary number that can be created from the given combination.
     * <p>
     * Note that the resulting string can have leading zeros.
     */
    public String maximumOddBinaryNumber(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        // Use two pointers, one at the start and one at the end
        int l = 0, r = n - 1;
        while (l <= r) {
            // Advance the left pointer if it's a '1'
            if (chars[l] == '1') l++;
            // Advance the right pointer if it's a '0'
            if (chars[r] == '0') r--;
            // Swap if left is '0' and right is '1'
            if (l <= r && chars[l] == '0' && chars[r] == '1') {
                chars[l] = '1';
                chars[r] = '0';
            }
        }

        // At the end, the left pointer is next to the rightmost '1'
        // So swap positions to put the '1' at the last index, to make it an odd number
        chars[l - 1] = '0';
        chars[n - 1] = '1';

        return new String(chars);
    }

}
