package com.ggwadera.array.easy;

import java.util.Arrays;

/**
 * Solution for <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">977. Squares of a Sorted Array</a>
 */
public class SquaresOfSortedArray {

    /**
     * Given an integer array nums sorted in non-decreasing order,
     * return an array of the squares of each number sorted in non-decreasing order.
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // Use two pointers at the start and end of the array.
        // As the array is sorted, when squaring negative numbers,
        // their absolute value may place them in another position in the result array.
        // So perform a kind of merge sort by comparing the absolute values, and already computing the square.
        int i = 0, j = n - 1;
        for (int k = n - 1; k >= 0; k--) {
            if (Math.abs(nums[i]) >= Math.abs(nums[j])) {
                ans[k] = nums[i] * nums[i];
                i++;
            } else {
                ans[k] = nums[j] * nums[j];
                j--;
            }
        }

        return ans;
        // Time complexity: O(n) (single pass through array)
        // Space complexity: O(n) (requires additional array allocation)
    }

    /**
     * Trivial solution by calculating the squares and sorting the array.
     */
    public int[] sortedSquaresTrivial(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
        // Time complexity: O(n log n) (due to sorting)
        // Space complexity: O(1)
    }

    /**
     * Trivial solution using streams.
     */
    public int[] sortedSquaresStream(int[] nums) {
        return Arrays.stream(nums).map(x -> x * x).sorted().toArray();
    }

}
