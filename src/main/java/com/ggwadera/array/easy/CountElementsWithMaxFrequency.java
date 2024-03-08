package com.ggwadera.array.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/count-elements-with-maximum-frequency/">3005. Count Elements With Maximum Frequency</a>
 */
public class CountElementsWithMaxFrequency {

    /**
     * You are given an array nums consisting of positive integers.
     * <p>
     * Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
     * <p>
     * The frequency of an element is the number of occurrences of that element in the array.
     */
    public int maxFrequencyElements(int[] nums) {
        // Create a map to record the frequency of each number
        // The problem constraints states that 1 <= nums[i] <= 100
        int[] map = new int[101];
        int max = 0;
        int count = 0;
        for (int num : nums) {
            // Increment the frequency for nums[i]
            int frequency = ++map[num];

            // If found a new max frequency
            if (frequency > max) {
                // Update the current max
                max = frequency;
                // Reset the count equal to the new max frequency
                count = frequency;
            } else if (frequency == max) {
                // Another number with the same max frequency
                // Increment into the current count
                count += frequency;
            }
        }
        return count;
        // Time: O(n) (single pass)
        // Space O(1) (constant size hash table)
    }

}
