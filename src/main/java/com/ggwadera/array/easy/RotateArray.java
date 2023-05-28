package com.ggwadera.array.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/rotate-array">189. Rotate Array</a>
 */
public class RotateArray {

    /**
     * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
     * <p>
     * Example: nums = [1,2,3,4,5,6,7]
     * <p>
     * [7,1,2,3,4,5,6], k = 1
     * <p>
     * [6,7,1,2,3,4,5], k = 2
     * <p>
     * [5,6,7,1,2,3,4], k = 3
     * <p>
     * [4,5,6,7,1,2,3], k = 4
     * <p>
     * [3,4,5,6,7,1,2], k = 5
     * <p>
     * [2,3,4,5,6,7,1], k = 6
     * <p>
     * [1,2,3,4,5,6,7], k = 7
     */
    public void rotate(int[] nums, int k) {
        // The rotation can be done with 3 reversal operations on the array
        // For example, for [1,2,3,4,5,6,7] and k = 3
        // Split the array in 2 parts, counting from the right where the first part of the array will end
        // [1, 2, 3, 4] and [5, 6, 7]

        // Calculate the index to perform the split
        int n = nums.length;
        int split = n - 1 - (k % n);

        // Reverse the left part =>    nums = [4, 3, 2, 1, 5, 6, 7]
        reverse(nums, 0, split);

        // Reverse the right part =>   nums = [4, 3, 2, 1, 7, 6, 5]
        reverse(nums, split + 1, n - 1);

        // Reverse the entire array => nums = [5, 6, 7, 1, 2, 3, 4]
        reverse(nums, 0, n - 1);
    }

    private static void reverse(int[] nums, int from, int to) {
        while (from < to) {
            int tmp = nums[from];
            nums[from] = nums[to];
            nums[to] = tmp;
            from++;
            to--;
        }
    }

}
