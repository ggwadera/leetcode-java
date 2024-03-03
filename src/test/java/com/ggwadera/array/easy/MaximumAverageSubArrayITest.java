package com.ggwadera.array.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumAverageSubArrayITest {


    @ParameterizedTest
    @MethodSource("parameterSource")
    void findMaxAverage(int[] nums, int k, double expected) {
        var solution = new MaximumAverageSubArrayI();
        assertThat(solution.findMaxAverage(nums, k)).isCloseTo(expected, within(1E-5));
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{1, 12, -5, -6, 50, 3}, 4, 12.75),
            arguments(new int[]{5}, 1, 5.0)
        );
    }
}