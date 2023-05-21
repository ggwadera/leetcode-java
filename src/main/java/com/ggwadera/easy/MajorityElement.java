package com.ggwadera.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for <a href="https://leetcode.com/problems/majority-element">169. Majority Element</a>
 */
public class MajorityElement {

    /**
     * Solved by hash map
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int mid = nums.length / 2;

        for (int num : nums) {
            int count = map.merge(num, 1, Integer::sum);
            if (count > mid) return num;
        }

        return nums[0];
    }

    /**
     * Solved by the Boyer-Moore Voting Algorithm
     */
    public int majorityElementBoyerMoore(int[] nums) {
        int count = 0;
        int candidate = nums[0];

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
