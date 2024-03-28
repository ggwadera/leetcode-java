package com.ggwadera.array.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for <a href="https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/">2958. Length of Longest Subarray With at Most K Frequency</a>
 */
public class LongestSubarrayWithAtMostKFrequency {

    /**
     * You are given an integer array nums and an integer k.
     * The frequency of an element x is the number of times it occurs in an array.
     * An array is called good if the frequency of each element in this array is less than or equal to k.
     * <p>
     * Return the length of the longest good subarray of nums.
     * A subarray is a contiguous non-empty sequence of elements within an array.
     */
    public int maxSubarrayLength(int[] nums, int k) {
        final Map<Integer, Integer> freqs = new HashMap<>();
        final int n = nums.length;
        int i = 0;
        int ans = 0;

        // Use a sliding window to find the longest subarray
        for (int j = 0; j < n; j++) {
            // Increase the window one step to the right
            int freq = freqs.compute(nums[j], (key, v) -> v == null ? 1 : v + 1);
            while (i < j && freq > k) {
                // Decrease the window from the left until the subarray is good again
                int ifreq = freqs.compute(nums[i], (key, v) -> v - 1);
                if (nums[i] == nums[j]) freq = ifreq;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

}
