package com.ggwadera.easy;

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
        if (i == -1) {
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            return arr;
        }
        digits[i] += 1;
        return digits;
    }

}
