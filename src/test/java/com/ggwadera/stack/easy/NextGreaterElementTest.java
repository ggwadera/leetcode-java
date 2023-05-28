package com.ggwadera.stack.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NextGreaterElementTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void nextGreaterElement(int[] nums1, int[] nums2, int[] expected) {
        var nge = new NextGreaterElement();
        assertThat(nge.nextGreaterElement(nums1, nums2)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(
                new int[]{4, 1, 2},
                new int[]{1, 3, 4, 2},
                new int[]{-1, 3, -1}
            ),
            arguments(
                new int[]{2, 4},
                new int[]{1, 2, 3, 4},
                new int[]{3, -1}
            )
        );
    }
}