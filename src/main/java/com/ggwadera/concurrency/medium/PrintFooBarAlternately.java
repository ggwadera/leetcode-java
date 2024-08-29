package com.ggwadera.concurrency.medium;

import java.util.concurrent.Semaphore;

/**
 * Solution for <a href="https://leetcode.com/problems/print-foobar-alternately/">Print FooBar Alternately</a>
 */
public class PrintFooBarAlternately {

    private final int n;
    private final Semaphore lockFoo = new Semaphore(0);
    private final Semaphore lockBar = new Semaphore(1);

    public PrintFooBarAlternately(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lockBar.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            lockFoo.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lockFoo.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            lockBar.release();
        }
    }

}
