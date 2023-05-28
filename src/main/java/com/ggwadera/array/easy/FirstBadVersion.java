package com.ggwadera.array.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/first-bad-version">278. First Bad Version</a>
 */
public class FirstBadVersion {

    private final int badVersion;

    protected FirstBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        int version = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                version = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return version;
    }

    private boolean isBadVersion(int version) {
        return version >= badVersion;
    }
}
