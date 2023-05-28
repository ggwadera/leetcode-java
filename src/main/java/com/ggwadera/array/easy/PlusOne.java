package com.ggwadera.array.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/plus-one">66. Plus One</a>
 */
public class PlusOne {

    /**
     * You are given a large integer represented as an integer array digits,
     * where each digits[i] is the ith digit of the integer.
     * The digits are ordered from most significant to least significant in left-to-right order.
     * The large integer does not contain any leading 0's.
     * <p>
     * Increment the large integer by one and return the resulting array of digits.
     */
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0 && digits[i] == 9) {
            digits[i--] = 0;
        }
        // If i == -1, all the digits were 9 (e.g.: [9, 9, 9, 9, 9])
        if (i == -1) {
            // Create a new array with size n + 1
            int[] arr = new int[digits.length + 1];
            // Set the first digit to 1, the remaining will be 0
            arr[0] = 1;
            // e.g.: arr = [1, 0, 0, 0, 0, 0]
            return arr;
        }

        digits[i] += 1;
        return digits;
    }

}
