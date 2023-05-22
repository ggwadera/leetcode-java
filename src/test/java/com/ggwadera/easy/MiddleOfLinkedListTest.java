package com.ggwadera.easy;

import com.ggwadera.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.LinkedListUtils.linkedListsAreEqual;
import static com.ggwadera.utils.LinkedListUtils.parseLinkedList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MiddleOfLinkedListTest {

    private static final MiddleOfLinkedList m = new MiddleOfLinkedList();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void middleNode(ListNode head, ListNode expected) {
        ListNode middle = m.middleNode(head);
        assertThat(linkedListsAreEqual(middle, expected)).isTrue();
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(parseLinkedList(1, 2, 3, 4, 5), parseLinkedList(3, 4, 5)),
            arguments(parseLinkedList(1, 2, 3, 4, 5, 6), parseLinkedList(4, 5, 6))
        );
    }

}