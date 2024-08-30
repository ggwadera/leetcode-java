package com.ggwadera.concurrency.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ZeroEvenOddTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
        3, 010203
        6, 010203040506
        15, 010203040506070809010011012013014015
        """)
    void test(final int n, final String expected) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(2 * n);
        final Queue<Integer> result = new LinkedBlockingQueue<>();
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        List<Thread> threads = getThreads(zeroEvenOdd, latch, result);
        Collections.shuffle(threads);

        threads.forEach(Thread::start);
        latch.await();

        String string = result.stream()
            .map(Object::toString)
            .collect(Collectors.joining());
        assertThat(string).isEqualTo(expected);
    }

    private List<Thread> getThreads(ZeroEvenOdd zeroEvenOdd, CountDownLatch latch, Queue<Integer> result) {
        List<Thread> threads = new ArrayList<>();
        threads.add(
            new Thread(() -> {
                try {
                    zeroEvenOdd.zero(i -> {
                        assertThat(i).as("Must be 0").isEqualTo(0);
                        latch.countDown();
                        result.add(i);
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            })
        );
        threads.add(
            new Thread(() -> {
                try {
                    zeroEvenOdd.odd(i -> {
                        assertThat(i % 2).as("Must be odd number").isEqualTo(1);
                        latch.countDown();
                        result.add(i);
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            })
        );
        threads.add(
            new Thread(() -> {
                try {
                    zeroEvenOdd.even(i -> {
                        assertThat(i % 2).as("Must be even number").isEqualTo(0);
                        latch.countDown();
                        result.add(i);
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            })
        );
        return threads;
    }

}