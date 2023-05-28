package com.ggwadera.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/subarray-product-less-than-k">713. Subarray Product Less Than K</a>
 */
public class SubarrayProductLessThanK {

    /**
     * Given an array of integers nums and an integer k, return the number of contiguous sub-arrays
     * where the product of all the elements in the subarray is strictly less than k.
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0;
        int curr = 1;
        int counter = 0;

        for (int right = 0; right < nums.length; right++) {
            curr *= nums[right];
            while (curr >= k) {
                curr /= nums[left];
                left++;
            }
            counter += right - left + 1;
        }

        return counter;
    }
}
