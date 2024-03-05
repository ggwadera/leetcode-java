package com.ggwadera.array.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/find-peak-element/">162. Find Peak Element</a>
 */
public class FindPeakElement {

    /**
     * A peak element is an element that is strictly greater than its neighbors.
     * <p>
     * Given a 0-indexed integer array nums, find a peak element, and return its index.
     * If the array contains multiple peaks, return the index to any of the peaks.
     * <p>
     * You may imagine that nums[-1] = nums[n] = -∞.
     * In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
     * <p>
     * You must write an algorithm that runs in O(log n) time.
     */
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == n - 1 || nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
