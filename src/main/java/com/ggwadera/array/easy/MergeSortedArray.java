package com.ggwadera.array.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/merge-sorted-array">88. Merge Sorted Array</a>
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for nums1
        int j = n - 1; // Pointer for nums2
        int k = m + n - 1; // Pointer for the merged array

        // Fill the merged array from the end
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
            k -= 1;
        }
    }

}
