package com.ggwadera.array.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SubarrayProductLessThanKTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void numSubarrayProductLessThanK(int[] nums, int k, int expected) {
        var s = new SubarrayProductLessThanK();
        assertThat(s.numSubarrayProductLessThanK(nums, k)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{10, 5, 2, 6}, 100, 8),
            arguments(new int[]{1, 2, 3}, 0, 0)
        );
    }

}