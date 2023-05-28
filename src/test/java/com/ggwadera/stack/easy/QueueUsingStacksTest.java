package com.ggwadera.stack.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueueUsingStacksTest {

    private static final QueueUsingStacks q = new QueueUsingStacks();

    @Test
    void test() {
        q.push(1);
        q.push(2);

        assertThat(q.peek()).isEqualTo(1);
        assertThat(q.pop()).isEqualTo(1);
        assertThat(q.empty()).isFalse();

        assertThat(q.peek()).isEqualTo(2);
        assertThat(q.pop()).isEqualTo(2);
        assertThat(q.empty()).isTrue();
    }
}