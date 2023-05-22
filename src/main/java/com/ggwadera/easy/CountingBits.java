package com.ggwadera.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/counting-bits">338. Counting Bits</a>
 */
public class CountingBits {

    /**
     * O(n) runtime complexity algorithm
     * O(1) space complexity
     * <p>
     * Algorithm:
     * <p>
     * Given an even integer, like 12 (0b1100), we can see that it has the same number of 1 bits as it's half 6 (0b0110).
     * Another example: 8 (0b1000) and 4 (0b0100). For even numbers, the least significant bit is always 0.
     * Note: integer division by 2 is the same as bit shifting 1 bit to the right (x / 2 == x >> 1).
     * <p>
     * Given an odd integer, like 7 (0b111), shifting a bit to the right results in 3 (0b011). Now to compensate for
     * that lost bit, for odd numbers we need to add 1 to the count.
     * Note: odd numbers always have the least significant bit set to 1.
     * <p>
     * Now going through all the numbers between 0 and n, to get the count of 1 bits we can just look back in the
     * answer array, for the number of bits in n / 2. And if n is odd, compensate by adding 1 more to the count.
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + i % 2;
        }
        return ans;
    }

    /*
    Example:
    n = 0  (0b0)    => ans[0] = 0
    n = 1  (0b1)    => ans[ 1 / 2] = ans[0] + 1 = 0 + 1 = 1
    n = 2  (0b10)   => ans[ 2 / 2] = ans[1] + 0 = 1 + 0 = 1
    n = 3  (0b11)   => ans[ 3 / 2] = ans[1] + 1 = 1 + 1 = 2
    n = 4  (0b100)  => ans[ 4 / 2] = ans[2] + 0 = 1 + 0 = 1
    n = 5  (0b101)  => ans[ 5 / 2] = ans[2] + 1 = 1 + 1 = 2
    n = 6  (0b110)  => ans[ 6 / 2] = ans[3] + 0 = 2 + 0 = 2
    n = 7  (0b111)  => ans[ 7 / 2] = ans[3] + 1 = 2 + 1 = 3
    n = 8  (0b1000) => ans[ 8 / 2] = ans[4] + 0 = 1 + 0 = 1
    n = 9  (0b1001) => ans[ 9 / 2] = ans[4] + 1 = 1 + 1 = 2
    n = 10 (0b1010) => ans[10 / 2] = ans[5] + 0 = 2 + 0 = 2
     */

}
