package com.ggwadera.array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Solution for <a href="https://leetcode.com/problems/contains-duplicate">217. Contains Duplicate</a>
 */
public class ContainsDuplicate {

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }

    /**
     * Time: O(n log n)
     * Space: O(1)
     */
    public boolean containsDuplicateSorted(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

}
