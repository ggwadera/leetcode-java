package com.ggwadera.array.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/move-zeroes">283. Move Zeroes</a>
 */
public class MoveZeroes {

    /**
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * <p>
     * Note that you must do this in-place without making a copy of the array.
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (n != 0) nums[i++] = n;
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }

}
