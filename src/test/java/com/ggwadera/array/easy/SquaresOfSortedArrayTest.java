package com.ggwadera.array.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SquaresOfSortedArrayTest {

    private static final SquaresOfSortedArray solution = new SquaresOfSortedArray();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void sortedSquares(int[] nums, int[] expected) {
        assertThat(solution.sortedSquares(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameterSource")
    void sortedSquaresTrivial(int[] nums, int[] expected) {
        assertThat(solution.sortedSquaresTrivial(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameterSource")
    void sortedSquaresStream(int[] nums, int[] expected) {
        assertThat(solution.sortedSquaresStream(nums)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{-4, -1, 0, 3, 10}, new int[]{0, 1, 9, 16, 100}),
            arguments(new int[]{-7, -3, 2, 3, 11}, new int[]{4, 9, 9, 49, 121})
        );
    }

}