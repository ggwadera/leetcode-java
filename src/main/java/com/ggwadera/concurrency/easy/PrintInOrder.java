package com.ggwadera.concurrency.easy;

import java.util.concurrent.Semaphore;

/**
 * Solution for <a href="https://leetcode.com/problems/print-in-order/">Print In Order</a>
 */
public class PrintInOrder {

    private final Semaphore s1 = new Semaphore(0);
    private final Semaphore s2 = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s1.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
