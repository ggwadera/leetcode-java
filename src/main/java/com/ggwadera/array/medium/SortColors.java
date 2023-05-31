package com.ggwadera.array.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/sort-colors">75. Sort Colors</a>
 */
public class SortColors {

    /**
     * Given an array nums with n objects colored red, white, or blue, sort them in-place so that
     * objects of the same color are adjacent, with the colors in the order red, white, and blue.
     * <p>
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     * <p>
     * You must solve this problem without using the library's sort function.
     */
    public void sortColors(int[] nums) {
        /*
         * This an example of https://en.wikipedia.org/wiki/Dutch_national_flag_problem
         */
        int l = 0, r = nums.length - 1, i = 0;
        while (i <= r) {
            if (nums[i] == 0) swap(nums, l++, i++);
            else if (nums[i] == 2) swap(nums, r--, i);
            else i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
