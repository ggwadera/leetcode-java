package com.ggwadera.array.medium;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class MaximumSubarrayTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void maxSubArray(int[] nums, int expected) {
        var m = new MaximumSubarray();
        assertThat(m.maxSubArray(nums)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
            arguments(new int[]{1}, 1),
            arguments(new int[]{5, 4, -1, 7, 8}, 23)
        );
    }
}