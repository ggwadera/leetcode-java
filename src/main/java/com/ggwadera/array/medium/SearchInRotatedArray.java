package com.ggwadera.array.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/search-in-rotated-sorted-array">33. Search in Rotated Sorted Array</a>
 */
public class SearchInRotatedArray {

    /**
     * There is an integer array nums sorted in ascending order (with distinct values).
     * <p>
     * Prior to being passed to your function, nums is possibly rotated at an unknown pivot
     * index k (1 <= k < nums.length) such that the resulting array is
     * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
     * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
     * <p>
     * Given the array nums after the possible rotation and an integer target,
     * return the index of target if it is in nums, or -1 if it is not in nums.
     * <p>
     * You must write an algorithm with O(log n) runtime complexity.
     */
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int num = nums[mid];
            if (num == target) return mid;

            if (nums[lo] <= num) {
                // Left side is monotonically increasing
                if (nums[lo] <= target && target < num) {
                    // Target is on the left side
                    hi = mid - 1;
                } else {
                    // Target is on the right side
                    lo = mid + 1;
                }
            } else {
                // Right side is monotonically increasing
                if (num < target && target <= nums[hi]) {
                    // Target is on the right side
                    lo = mid + 1;
                } else {
                    // Target is on the left side
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
