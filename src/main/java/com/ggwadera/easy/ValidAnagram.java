package com.ggwadera.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Solution for <a href="https://leetcode.com/problems/valid-anagram">242. Valid Anagram</a>
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        // Anagrams must have the same length
        if (s.length() != t.length()) return false;

        // Initialize an array to hold the frequency of each character in s
        int[] charCounter = new int[26];

        for (char c : s.toCharArray()) {
            // Populate the frequency array
            charCounter[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            // Subtract the frequency for the characters in t
            charCounter[c - 'a']--;
        }

        for (int counter : charCounter) {
            // If the frequency of any character is greater than 0, it's not a valid anagram
            if (counter > 0) return false;
        }
        return true;
    }

    public boolean isAnagramStream(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<String, Long> frequencies = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        Arrays.stream(t.split(""))
                .forEach(c -> frequencies.computeIfPresent(c, (k, v) -> v - 1));

        return frequencies.values().stream().noneMatch(f -> f != 0);
    }

}
