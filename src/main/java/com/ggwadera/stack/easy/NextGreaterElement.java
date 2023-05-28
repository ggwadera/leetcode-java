package com.ggwadera.stack.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution for <a href="https://leetcode.com/problems/next-greater-element-i">496. Next Greater Element I</a>
 */
public class NextGreaterElement {

    /**
     * The next greater element of some element x in an array is the first greater element that is to the right of x in
     * the same array.
     * <p>
     * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
     * <p>
     * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater
     * element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
     * <p>
     * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
     * <p></p>
     * Time complexity: O(n1 + n2) - single pass through both arrays
     * <p>
     * Space complexity: O(n1 + n2) - a map for nums1 and a stack for nums2
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        // Put the values from nums1 into a map to fill the answer array later
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            // Number as the key and index as the value
            map.put(nums1[i], i);
        }

        // Use a stack to find the next greater element
        Deque<Integer> stack = new ArrayDeque<>();

        // Loop from the right to the left of the array
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            int nge = -1;

            while (!stack.isEmpty() && nge == -1) {
                // Pop the stack until finding a greater element
                int next = stack.peek();
                if (next <= num) stack.pop();
                else nge = next;
            }

            // Push the current element as it is a possible candidate for the next
            stack.push(num);

            // If this element is in the map, fill the answer array with the next greater element
            if (map.containsKey(num)) {
                ans[map.get(num)] = nge;
            }
        }

        return ans;
    }
}
