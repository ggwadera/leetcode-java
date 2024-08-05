package com.ggwadera.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for <a href="https://leetcode.com/problems/kth-distinct-string-in-an-array/">2053. Kth Distinct String in an Array</a>
 */
public class KthDistinctString {

    /**
     * A distinct string is a string that is present only once in an array.
     * <p>
     * Given an array of strings arr, and an integer k, return the kth distinct string present in arr.
     * If there are fewer than k distinct strings, return an empty string "".
     * <p>
     * Note that the strings are considered in the order in which they appear in the array.
     */
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.merge(s, 1, (key, v) -> v + 1);
        }
        for (String s : arr) {
            if (map.get(s) == 1) k--;
            if (k == 0) return s;
        }
        return "";
    }

}
