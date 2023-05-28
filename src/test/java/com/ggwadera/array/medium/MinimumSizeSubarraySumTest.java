package com.ggwadera.array.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumSizeSubarraySumTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void minSubArrayLen(int target, int[] nums, int expected) {
        var m = new MinimumSizeSubarraySum();
        assertThat(m.minSubArrayLen(target, nums)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(7, new int[]{2, 3, 1, 2, 4, 3}, 2),
            arguments(4, new int[]{1, 4, 4}, 1),
            arguments(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 0),
            arguments(15, new int[]{1, 2, 3, 4, 5}, 5)
        );
    }
}