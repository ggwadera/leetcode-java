package com.ggwadera.array.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/find-the-highest-altitude">1732. Find the Highest Altitude</a>
 */
public class FindTheHighestAltitude {

    /**
     * There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
     * You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
     */
    public int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        for (int g : gain) {
            sum += g;
            max = Math.max(sum, max);
        }
        return max;
    }

}
