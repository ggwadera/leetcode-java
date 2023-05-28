package com.ggwadera.array.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/remove-element">27. Remove Element</a>
 */
public class RemoveElement {

    /**
     * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
     * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
     * <p>
     * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
     * <p>
     * - Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
     * The remaining elements of nums are not important as well as the size of nums.
     * <p>
     * - Return k.
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            // When nums[i] is the value to be removed, swap with the element at the end of the array,
            // also reducing the size of the array by one
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
