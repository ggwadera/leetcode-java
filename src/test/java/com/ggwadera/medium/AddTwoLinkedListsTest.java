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

class AddTwoLinkedListsTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void addTwoNumbers(ListNode l1, ListNode l2, ListNode expected) {
        var a = new AddTwoLinkedLists();
        ListNode result = a.addTwoNumbers(l1, l2);
        assertThat(linkedListsAreEqual(result, expected)).isTrue();
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(
                parseLinkedList(2,4,3),
                parseLinkedList(5,6,4),
                parseLinkedList(7,0,8)
            ),
            arguments(
                parseLinkedList(0),
                parseLinkedList(0),
                parseLinkedList(0)
            ),
            arguments(
                parseLinkedList(9,9,9,9,9,9,9),
                parseLinkedList(9,9,9,9),
                parseLinkedList(8,9,9,9,0,0,0,1)
            ),
            arguments(
                parseLinkedList(9,9,9,9),
                parseLinkedList(9,9,9,9,9,9,9),
                parseLinkedList(8,9,9,9,0,0,0,1)
            )
        );
    }
}