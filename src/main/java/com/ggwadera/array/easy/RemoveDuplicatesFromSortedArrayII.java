package com.ggwadera.array.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii">80. Remove Duplicates from Sorted Array II</a>
 */
public class RemoveDuplicatesFromSortedArrayII {

    /**
     * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each
     * unique element appears at most twice. The relative order of the elements should be kept the same.
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums [i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}
