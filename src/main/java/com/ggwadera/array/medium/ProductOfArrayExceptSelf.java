package com.ggwadera.array.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/product-of-array-except-self/">238. Product of Array Except Self</a>
 */
public class ProductOfArrayExceptSelf {

    /**
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all
     * the elements of nums except nums[i].
     * <p>
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * <p>
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     */
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        final int[] ans = new int[n];
        // Logic here is to calculate `left * right` for each nums[i]

        // Calculate the left product for each nums[i]
        // (Product of all elements to the left of nums[i]
        // Store it on the answer array
        int mult = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = mult;
            mult *= nums[i];
        }

        // Now calculate the resulting product, while also keeping the right product in a variable
        mult = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= mult;
            mult *= nums[i];
        }
        return ans;
    }

}
