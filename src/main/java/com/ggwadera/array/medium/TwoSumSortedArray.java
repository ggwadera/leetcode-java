package com.ggwadera.array.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted">167. Two Sum II - Input Array Is Sorted</a>
 */
public class TwoSumSortedArray {

    /**
     * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
     * <p>
     * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
     * <p>
     * You may not use the same element twice.
     * <p>
     * Your solution must use only constant extra space.
     */
    public int[] twoSum(int[] numbers, int target) {
        // Create two pointers, one at the start and one at the end of the array
        int lo = 0;
        int hi = numbers.length - 1;

        // Compute the current sum
        var sum = numbers[lo] + numbers[hi];

        // Loop until a solution is found (solution is guaranteed to exist as per the problem statement)
        while (sum != target) {
            if (sum < target) {
                // If the sum is lower than the target, move the left pointer
                lo++;
            } else {
                // Otherwise, if the sum is greater than the target, move the right pointer
                hi--;
            }
            // Compute the new sum
            sum = numbers[lo] + numbers[hi];
        }
        // Return the indices, incremented by one as required
        return new int[]{lo + 1, hi + 1};
    }

}
