package com.ggwadera.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution for <a href="https://leetcode.com/problems/valid-parentheses">20. Valid Parenthesis</a>
 */
public class ValidParenthesis {

    public boolean isValid(String s) {
        // 1. Define a FIFO stack to hold the opening characters (the Stack class is legacy and should not be used!).
        final Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {

                // 2. If it's an opening character, push it to the stack.
                stack.push(c);

            } else {

                // 3. If it's a closing character, check the stack to compare if it is correct.
                // First check if the stack is empty, if it's empty the parenthesis are unbalanced.
                if (stack.isEmpty()) return false;

                // 4. Pop the stack to get the last character that was added.
                char last = stack.pop();

                // 5. Compare with the current character to see if it is the correct closing character.
                if (c == ')' && last != '(') return false;
                if (c == '}' && last != '{') return false;
                if (c == ']' && last != '[') return false;
            }
        }

        // 6. If the loop ends, check if there's any remaining characters on the stack.
        return stack.isEmpty();
    }

}
