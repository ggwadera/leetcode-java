package com.ggwadera.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/number-of-1-bits">191. Number of 1 Bits</a>
 */
public class HammingWeight {

    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            // AND the first bit to check if it's set
            sum += (n & 1);

            // Shift n by 1 bit (>>> is the unsigned bit shift operator)
            // Java does not have unsigned numbers,
            // so >> could cycle back after Integer.MAX_VALUE or Integer.MIN_VALUE
            n = n >>> 1;
        }
        return sum;
    }

}
