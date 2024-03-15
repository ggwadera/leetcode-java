package com.ggwadera.array.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/largest-palindromic-number/">2384. Largest Palindromic Number</a>
 */
public class LargestPalindromicNumber {

    /**
     * You are given a string num consisting of digits only.
     * Return the largest palindromic integer (in the form of a string) that can be formed using digits taken from num. It should not contain leading zeroes.
     * <p>
     * Notes:
     * <ul>
     * <li>You do not need to use all the digits of num, but you must use at least one digit.</li>
     * <li>The digits can be reordered.</li>
     * </ul>
     */
    public String largestPalindromic(String num) {
        final int[] counter = new int[10];
        final char[] chars = num.toCharArray();

        // Create a map with the frequency of each digit
        for (char c : chars) counter[c - '0']++;

        int mid = -1;
        final StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (sb.isEmpty() && i == 0) continue;

            // Keep adding to the string while there's more than one element of the digit
            while (counter[i] > 1) {
                sb.append(i);
                // Decrement by 2 as the string will be concatenated with its reverse at the end
                counter[i] -= 2;
            }

            // Save the greatest digit with odd frequency to insert at the middle
            if (counter[i] == 1 && mid == -1) {
                mid = i;
            }
        }

        if (sb.isEmpty()) {
            if (mid == -1) return "0";
            return Integer.toString(mid);
        }

        return sb.toString() + (mid == -1 ? "" : mid) + sb.reverse().toString();
    }

}
