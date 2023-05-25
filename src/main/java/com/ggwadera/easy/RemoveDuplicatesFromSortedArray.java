package com.ggwadera.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array">26. Remove Duplicates from Sorted Array</a>
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
     * element appears only once. The relative order of the elements should be kept the same.
     * Then return the number of unique elements in nums.
     * <p>
     * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
     * <p>
     * - Change the array nums such that the first k elements of nums contain the unique elements in the order they
     * were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
     * <p>
     * - Return k.
     */
    public int removeDuplicates(int[] nums) {
        // Start from index 1, because the array is sorted so no need to check the first element;
        int i = 1;

        // Increment j until finding a greater element than nums[i - 1]
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > nums[i - 1]) {
                // Replace the duplicate with nums[j] and increment i
                nums[i++] = nums[j];
            }
        }

        // i is also equal to the value of non duplicates
        return i;
    }
}
