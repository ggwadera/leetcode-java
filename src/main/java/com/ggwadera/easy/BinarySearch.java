package com.ggwadera.easy;

public class BinarySearch {

    public int search(int[] nums, int target) {
        // Initialize the left and right bounds for the search
        int left = 0, right = nums.length - 1;
        int mid, cur;

        while (left <= right) {
            // Calculate the midpoint
            mid = left + (right - left) / 2;

            // Check if target was found
            cur = nums[mid];
            if (cur == target) return mid;

            if (cur > target) {
                // The current number is greater than the target, move the right bound to the left of the midpoint
                right = mid - 1;
            } else {
                // The current number is lesser than the target, move the left bound to the right of the midpoint
                left = mid + 1;
            }
        }

        return -1;
    }

    public int searchRecursive(int[] nums, int target) {
        return searchRecursive(nums, target, 0, nums.length);
    }

    private int searchRecursive(int[] nums, int target, int low, int high) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;
        if (nums[mid] == target) return mid;
        return nums[mid] > target
                ? searchRecursive(nums, target, low, mid - 1)
                : searchRecursive(nums, target, mid + 1, high);
    }

}
