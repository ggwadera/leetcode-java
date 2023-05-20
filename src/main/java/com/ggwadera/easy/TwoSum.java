package com.ggwadera.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for <a href="https://leetcode.com/problems/two-sum">1. Two Sum</a>
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // While we are iterating and inserting elements into the hash table,
            // we also look back to check if current element's complement already exists in the hash table.
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                // If it exists, we have found a solution and return the indices immediately.
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
