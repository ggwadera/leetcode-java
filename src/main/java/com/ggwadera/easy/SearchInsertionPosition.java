package com.ggwadera.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/search-insert-position">35. Search Insert Position</a>
 */
public class SearchInsertionPosition {

    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * <p>
     * You must write an algorithm with O(log n) runtime complexity.
     */
    public int searchInsert(int[] nums, int target) {
        // Do a binary search to search for the insertion point, since it's a sorted array
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // If the target was not found, then right will end at the index before the insertion point
        return right + 1;
    }

}
