package com.ggwadera.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for <a href="https://leetcode.com/problems/kids-with-the-greatest-number-of-candies">1431. Kids With the Greatest Number of Candies</a>
 */
public class KidsWithCandies {

    /**
     * There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.
     * <p>
     * Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
     * <p>
     * Note that multiple kids can have the greatest number of candies.
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int max = candies[0];
        for (int c : candies) {
            if (c > max) max = c;
        }

        List<Boolean> result = new ArrayList<>(n);
        for (int c : candies) {
            result.add(c + extraCandies >= max);
        }
        return result;
    }

}
