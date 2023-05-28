package com.ggwadera.bit.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/reverse-bits">190. Reverse Bits</a>
 */
public class ReverseBits {

    public int reverseBits(int n) {
        // Initialize a mask with a single bit set on the leftmost position (32)
        int mask = 1 << 31;
        int reversed = 0;

        // Loop for every bit (considering 32 bit integer)
        for (int i = 0; i < 32; i++) {
            // If the rightmost bit of n is set, XOR the result
            // with the mask to set the bit in the reverse position
            if ((n & 1) == 1) reversed |= mask;

            // Bit shift the mask and n to the right, to work on the next bit
            mask = mask >>> 1;
            n = n >>> 1;
        }
        return reversed;
    }

}
