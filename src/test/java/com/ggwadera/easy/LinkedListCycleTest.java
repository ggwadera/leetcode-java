package com.ggwadera.easy;

import com.ggwadera.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.TestUtils.parseLinkedList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LinkedListCycleTest {

    private static final LinkedListCycle l = new LinkedListCycle();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void hasCycle(ListNode head, boolean expected) {
        assertThat(l.hasCycle(head)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(createCycle(parseLinkedList(3,2,0,-4), 1), true),
            arguments(createCycle(parseLinkedList(1,2), 0), true),
            arguments(parseLinkedList(1), false)
        );
    }

    private static ListNode createCycle(ListNode head, int nodeIndex) {
        ListNode connection = null, tail = head;
        int i = 0;
        while (tail.next != null) {
            if (i++ == nodeIndex) connection = tail;
            tail = tail.next;
        }
        tail.next = connection;
        return head;
    }
}