package com.ggwadera.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution for <a href="https://leetcode.com/problems/daily-temperatures">739. Daily Temperatures</a>
 */
public class DailyTemperatures {

    /**
     * Given an array of integers temperatures represents the daily temperatures, return an array answer such that
     * answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
     * If there is no future day for which this is possible, keep answer[i] == 0 instead.
     * <p>
     * Time complexity: O(n) - single pass through the array
     * Space complexity: O(n) - stack is used (ignoring the space required for the result array)
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        // Use a stack to keep track of the index of warmer temperatures.
        Deque<Integer> stack = new ArrayDeque<>();

        // Start from the end of the array and move to the start
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int days = 0;
            while (!stack.isEmpty() && days == 0) {
                // Compare the current temperature with the top of the stack
                int j = stack.peek();
                if (temperatures[j] <= temperatures[i]) {
                    // If temperature from the stack is lower, pop the top element
                    // Because it is lower, it can never be warmer than the current temperature for the next elements
                    stack.pop();
                } else {
                    // If the temperature from the stack is warmer, calculate the number of days
                    days = j - i;
                }
            }
            answer[i] = days;

            // Push the current temperature to the stack as it is a possible candidate for the next temperature.
            stack.push(i);
        }
        return answer;
    }
}
