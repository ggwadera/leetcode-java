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

class MergeSortedLinkedListsTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void mergeTwoLists(ListNode l1, ListNode l2, ListNode expected) {
        var m = new MergeSortedLinkedLists();
        var result = m.mergeTwoLists(l1, l2);
        assertThat(linkedListsAreEqual(result, expected)).isTrue();
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(
                parseLinkedList(1, 2, 4),
                parseLinkedList(1, 3, 4),
                parseLinkedList(1, 1, 2, 3, 4, 4)
            ),
            arguments(
                parseLinkedList(),
                parseLinkedList(0),
                parseLinkedList(0)
            )
        );
    }

}