package com.ggwadera.array.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for <a href="https://leetcode.com/problems/contiguous-array/">525. Contiguous Array</a>
 */
public class ContiguousArray {

    /**
     * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
     */
    public int findMaxLength(int[] nums) {
        final int n = nums.length;
        final Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            final Integer last = map.get(sum);
            if (last != null) {
                max = Math.max(max, i - last);
            } else if (sum == 0) {
                max = Math.max(max, i + 1);
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }

}
