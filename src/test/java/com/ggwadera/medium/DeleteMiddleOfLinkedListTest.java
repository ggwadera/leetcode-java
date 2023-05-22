package com.ggwadera.medium;

import com.ggwadera.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.LinkedListUtils.linkedListsAreEqual;
import static com.ggwadera.utils.LinkedListUtils.parseLinkedList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DeleteMiddleOfLinkedListTest {

    private static final DeleteMiddleOfLinkedList d = new DeleteMiddleOfLinkedList();

    @ParameterizedTest
    @MethodSource("parameterProvider")
    void deleteMiddle(ListNode head, ListNode expected) {
        ListNode list = d.deleteMiddle(head);
        assertThat(linkedListsAreEqual(list, expected)).isTrue();
    }

    public static Stream<Arguments> parameterProvider() {
        return Stream.of(
            arguments(parseLinkedList(1, 3, 4, 7, 1, 2, 6), parseLinkedList(1, 3, 4, 1, 2, 6)),
            arguments(parseLinkedList(1, 2, 3, 4), parseLinkedList(1, 2, 4)),
            arguments(parseLinkedList(2, 1), parseLinkedList(2)),
            arguments(parseLinkedList(1), null)
        );
    }

}