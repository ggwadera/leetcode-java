package com.ggwadera.bit.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/single-number">136. Single Number</a>
 */
public class SingleNumber {

    /**
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     */
    public int singleNumber(int[] nums) {
        // XOR every number in the array. The duplicates will cancel itself because x ^ x = 0.
        // So only the single number will remain, as x ^ 0 = x.
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

}
