package com.ggwadera.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/ransom-note">383. Ransom Note</a>
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] frequencies = new int[26];
        for (char c : magazine.toCharArray()) {
            frequencies[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (--frequencies[c - 'a'] < 0) return false;
        }
        return true;
    }

}
