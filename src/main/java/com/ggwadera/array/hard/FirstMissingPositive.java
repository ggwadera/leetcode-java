package com.ggwadera.array.hard;

/**
 * Solution for <a href="https://leetcode.com/problems/first-missing-positive/">41. First Missing Positive</a>
 */
public class FirstMissingPositive {

    /**
     * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
     * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
     */
    public int firstMissingPositive(int[] nums) {
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) nums[i] = n + 1;
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) continue;
            num--;
            if (nums[num] > 0) {
                nums[num] *= -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) return i + 1;
        }
        return n + 1;
    }

}
