package com.ggwadera.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/minimum-size-subarray-sum">Minimum Size Subarray Sum</a>
 */
public class MinimumSizeSubarraySum {

    /**
     * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
     * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
     */
    public int minSubArrayLen(int target, int[] nums) {
        // Use a sliding window to track the sum and find the minimum
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            // Move the right pointer until finding the target sum
            sum += nums[right++];
            while (sum >= target) {
                // Update the minimum value for this window
                min = Math.min(min, right - left);
                // Move the left pointer, making the window smaller and updating the sum
                sum -= nums[left++];
                // Repeat until the sum is less than the target
            }
        }
        // If no minimum was found, min will be unmodified
        return min != Integer.MAX_VALUE ? min : 0;
    }

}
