package com.ggwadera.array.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/maximum-subarray">53. Maximum Subarray</a>
 */
public class MaximumSubarray {

    /**
     * Given an integer array nums, find the subarray with the largest sum, and return its sum.
     */
    public int maxSubArray(int[] nums) {
        int cur = 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            cur = Math.max(num, cur + num);
            max = Math.max(max, cur);
        }

        return max;
    }
}
