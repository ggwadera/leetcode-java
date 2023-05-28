package com.ggwadera.bit.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/sum-of-two-integers">371. Sum of Two Integers</a>
 */
public class SumOfTwoInteger {

    /**
     * Given two integers a and b, return the sum of the two integers without using the operators + and -.
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            // Use AND to find the carry
            // Ex.: 011 & 110 = 010
            int carry = a & b;

            // Use XOR to set the different bits from a and b
            // Ex.: 011 ^ 110 = 101
            a = a ^ b;

            // Bit shift the carry to the left, so it gets added in the next iteration
            // Continue the loop until the carry (assigned to b) is 0
            // Ex.: 010 << 1 = 100
            b = carry << 1;
        }
        return a;
    }

}
