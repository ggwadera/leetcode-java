package com.ggwadera.array.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MoveZeroesTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void moveZeroes(int[] nums, int[] expected) {
        new MoveZeroes().moveZeroes(nums);
        assertThat(nums).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}),
            arguments(new int[]{0}, new int[]{0}),
            arguments(new int[]{1, 0}, new int[]{1, 0}),
            arguments(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0})
        );
    }
}