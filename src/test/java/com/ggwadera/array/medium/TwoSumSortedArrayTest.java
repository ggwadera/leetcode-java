package com.ggwadera.array.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TwoSumSortedArrayTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void twoSum(int[] numbers, int target, int[] expected) {
        var solution = new TwoSumSortedArray();
        assertThat(solution.twoSum(numbers, target)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}),
            arguments(new int[]{2, 3, 4}, 6, new int[]{1, 3}),
            arguments(new int[]{-1, 0}, -1, new int[]{1, 2})
        );
    }
}