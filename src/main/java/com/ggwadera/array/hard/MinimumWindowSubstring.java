package com.ggwadera.array.hard;

/**
 * Solution for <a href="https://leetcode.com/problems/minimum-window-substring">76. Minimum Window Substring</a>
 */
public class MinimumWindowSubstring {

    /**
     * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that
     * every character in t (including duplicates) is included in the window.
     * If there is no such substring, return the empty string "".
     */
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();

        int[] map = new int[128];
        int[] window = new int[128];
        int lenW = 0;
        for (char c : t.toCharArray()) map[c]++;

        int l = 0, min = Integer.MAX_VALUE;
        int minL = 0, minR = 0;
        for (int r = 0; r < m; r++) {
            char c = s.charAt(r);
            window[c]++;
            if (window[c] <= map[c]) {
                lenW++;
            }

            while (lenW >= n) {
                if ((r - l) < min) {
                    min = r - l;
                    minL = l;
                    minR = r;
                }
                char cL = s.charAt(l);
                window[cL]--;
                if (window[cL] < map[cL]) {
                    lenW--;
                }
                l++;
            }
        }

        return min == Integer.MAX_VALUE
            ? ""
            : s.substring(minL, minR + 1);
    }

}
