package com.ggwadera.array.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/valid-palindrome">125. Valid Palindrome</a>
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s.length() < 2) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            // character at the left position
            char left = s.charAt(i);
            if (isInvalidCharacter(left)) {
                // if it's not valid, move the pointer and restart the loop
                i++;
                continue;
            }

            // character at the right position
            char right = s.charAt(j);
            if (isInvalidCharacter(right)) {
                // if it's not valid, move the pointer and restart the loop
                j--;
                continue;
            }

            // both characters need to be equal to be a valid palindrome
            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }

            // increment pointers to check the next position
            i++;
            j--;
        }
        return true;
    }

    private boolean isInvalidCharacter(char c) {
        return !Character.isLetterOrDigit(c);
    }

}
