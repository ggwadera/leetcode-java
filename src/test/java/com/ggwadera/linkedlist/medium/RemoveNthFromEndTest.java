package com.ggwadera.linkedlist.medium;

import com.ggwadera.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.LinkedListUtils.isEqualTo;
import static com.ggwadera.utils.LinkedListUtils.parseLinkedList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoveNthFromEndTest {


    @ParameterizedTest
    @MethodSource("parameterSource")
    void removeNthFromEnd(ListNode head, int n, ListNode expected) {
        var solution = new RemoveNthFromEnd();
        assertThat(solution.removeNthFromEnd(head, n)).satisfies(isEqualTo(expected));
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(parseLinkedList(1, 2, 3, 4, 5), 2, parseLinkedList(1, 2, 3, 5)),
            arguments(parseLinkedList(1), 1, null),
            arguments(parseLinkedList(1, 2), 1, parseLinkedList(1)),
            arguments(parseLinkedList(1, 2), 2, parseLinkedList(2))
        );
    }
}