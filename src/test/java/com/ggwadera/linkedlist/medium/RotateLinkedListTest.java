package com.ggwadera.linkedlist.medium;

import com.ggwadera.common.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.LinkedListUtils.linkedListsAreEqual;
import static com.ggwadera.utils.LinkedListUtils.parseLinkedList;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RotateLinkedListTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void rotateRight(ListNode head, int k, ListNode expected) {
        var r = new RotateLinkedList();
        var result = r.rotateRight(head, k);
        Assertions.assertThat(linkedListsAreEqual(result, expected)).isTrue();
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(
                parseLinkedList(1, 2, 3, 4, 5),
                2,
                parseLinkedList(4, 5, 1, 2, 3)
            ),
            arguments(
                parseLinkedList(0, 1, 2),
                4,
                parseLinkedList(2, 0, 1)
            ),
            arguments(
                parseLinkedList(1, 2),
                1,
                parseLinkedList(2, 1)
            ),
            arguments(
                parseLinkedList(1, 2, 3, 4, 5),
                5,
                parseLinkedList(1, 2, 3, 4, 5)
            ),
            arguments(
                new ListNode(1),
                50,
                new ListNode(1)
            ),
            arguments(
                null,
                5,
                null
            )
        );
    }
}