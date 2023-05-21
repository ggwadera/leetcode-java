package com.ggwadera.easy;

import com.ggwadera.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.TestUtils.linkedListsAreEqual;
import static com.ggwadera.TestUtils.parseLinkedList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReverseLinkedListTest {

    private static final ReverseLinkedList r = new ReverseLinkedList();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void reverseList(ListNode head, ListNode expected) {
        ListNode reversed = r.reverseList(head);
        assertThat(linkedListsAreEqual(reversed, expected)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("parameterSource")
    void reverseListRecursion(ListNode head, ListNode expected) {
        ListNode reversed = r.reverseListRecursion(head);
        assertThat(linkedListsAreEqual(reversed, expected)).isTrue();
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(parseLinkedList(1, 2, 3, 4, 5), parseLinkedList(5, 4, 3, 2, 1)),
            arguments(parseLinkedList(1, 2), parseLinkedList(2, 1)),
            arguments(null, null)
        );
    }
}