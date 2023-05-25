package com.ggwadera.easy;

import java.util.Map;

/**
 * Solution for <a href="https://leetcode.com/problems/roman-to-integer">13. Roman to Integer</a>
 */
public class RomanToInteger {

    private static final Map<Character, Integer> ROMAN_TO_INT = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );

    /**
     * Given a roman numeral, convert it to an integer.
     */
    public int romanToInt(String s) {
        int prev = 0;
        int sum = 0;

        // As roman numerals are written from largest to smaller, start reading the string from left to right,
        // this way it's easier to convert combinations like IV, IX, XL, XC, CD, and CM.
        for (int i = s.length() - 1; i >= 0; i--) {
            int num = ROMAN_TO_INT.get(s.charAt(i));

            // If the current number is lower than the previous, it's a combination = subtraction
            if (num < prev) sum -= num;
            else sum += num;
            prev = num;
        }
        return sum;
    }

}
