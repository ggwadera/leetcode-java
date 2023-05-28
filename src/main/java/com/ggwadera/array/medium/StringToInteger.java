package com.ggwadera.array.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/string-to-integer-atoi">8. String to Integer (atoi)</a>
 */
public class StringToInteger {

    /**
     * The algorithm for myAtoi(string s) is as follows:
     * <p>
     * Read in and ignore any leading whitespace.
     * <p>
     * Check if the next character (if not already at the end of the string) is '-' or '+'.
     * Read this character in if it is either.
     * This determines if the final result is negative or positive respectively.
     * Assume the result is positive if neither is present.
     * <p>
     * Read in next the characters until the next non-digit character or the end of the input is reached.
     * The rest of the string is ignored.
     * <p>
     * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32).
     * If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
     * <p>
     * If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
     * then clamp the integer so that it remains in the range.
     * Specifically, integers less than -231 should be clamped to -231,
     * and integers greater than 231 - 1 should be clamped to 231 - 1.
     * <p>
     * Return the integer as the final result.
     * <p>
     * Note:
     * <p>
     * Only the space character ' ' is considered a whitespace character.
     * <p>
     * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
     */
    public int myAtoi(String s) {
        if (s.length() == 0) return 0;

        int i = 0;
        int sign = 1; // Assume positive if no sign on the input
        int result = 0;

        // Move the index until there's no whitespace
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // If reached the end of the string return;
        if (i == s.length()) return 0;

        // Read the sign if present
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i += 1;
        }

        // Read the rest of the string
        while (i < s.length()) {
            int num = s.charAt(i++) - '0';

            // If it's not a digit, stop and return
            if (num < 0 || num > 9) {
                break;
            }

            // Check for overflow and underflow
            if ((Integer.MAX_VALUE - num) / 10 < result) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Add the digit to the resulting number
            result = (result * 10) + num;
        }

        return sign * result;
    }

}
