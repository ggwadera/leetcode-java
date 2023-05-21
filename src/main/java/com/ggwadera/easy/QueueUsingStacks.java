package com.ggwadera.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution for <a href="https://leetcode.com/problems/implement-queue-using-stacks">232. Implement Queue using Stacks</a>
 */
public class QueueUsingStacks {

    private final Deque<Integer> stack1 = new ArrayDeque<>();
    private final Deque<Integer> stack2 = new ArrayDeque<>();
    private Integer head = null;

    public QueueUsingStacks() {
    }

    public void push(int x) {
        if (head == null) head = x;
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int last = stack2.pop();
        head = stack2.peek();
        return last;
    }

    public int peek() {
        return head;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
