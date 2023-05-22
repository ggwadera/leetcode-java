package com.ggwadera.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/add-binary">67. Add Binary</a>
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        var sb = new StringBuilder();

        // Start from the end of the strings
        int i = a.length() - 1;
        int j = b.length() - 1;

        // Carry will hold a value when the sum is greater than 1
        int carry = 0;

        // Loop until both strings are done, and carry is empty
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            // If a = 1, b = 1, carry will be 1 and 0 is added to the string
            carry = sum > 1 ? 1 : 0;

            // Take the modulo to append the string
            // 0 mod 2 = 0, 1 mod 2 = 1, 2 mod 2 = 0, 3 mod 2 = 1
            sb.append(sum % 2);
        }
        return sb.reverse().toString();
    }

}
