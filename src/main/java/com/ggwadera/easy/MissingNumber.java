package com.ggwadera.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/missing-number">268. Missing Number</a>
 */
public class MissingNumber {

    /**
     * Given an array nums containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array.
     *
     * @return the missing number from the array
     */
    public int missingNumber(int[] nums) {
        // By XOR'ing every number in the array with the numbers from [0, n], only the missing number will remain.
        // 1. XOR'ing a number by itself results in 0.
        // 2. XOR is commutative and associative, so the order of operation doesn't matter.
        // 3. XOR'ing a number by 0 will leave the number unchanged.
        // 4. So eventually we'll get 0 XOR the missing number, which will be the answer.
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i;
            missing ^= nums[i];
        }
        return missing;
    }

    public int missingNumberSum(int[] nums) {
        // Another approach is by calculating the sum of [0, n], and taking the difference of the numbers in the array.
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += i;
            sum -= nums[i];
        }
        return sum;
    }

}
