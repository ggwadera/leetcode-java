package com.ggwadera.math.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/sqrtx">69. Sqrt(x)</a>
 */
public class Sqrt {

    /**
     * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
     * The returned integer should be non-negative as well.
     */
    public int mySqrt(int x) {
        // Use binary search to find the square root in the range [1, x]
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sqrt = x / mid;
            if (mid == sqrt) return mid;
            if (mid < sqrt) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
