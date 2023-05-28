package com.ggwadera.math.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/powx-n">50. Pow(x, n)</a>
 */
public class Pow {

    /**
     * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
     */
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) return 1.0;

        // x^n = (x^n/2)^2 = x * x^n/2
        if (n < 0) return 1 / x * myPow(1 / x, -(n + 1));
        return n % 2 == 0
            ? myPow(x * x, n / 2)
            : x * myPow(x * x, n / 2);
    }

}
