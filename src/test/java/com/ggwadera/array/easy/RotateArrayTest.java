package com.ggwadera.array.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RotateArrayTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void rotate(int[] nums, int k, int[] expected) {
        new RotateArray().rotate(nums, k);
        assertThat(nums).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}),
            arguments(new int[]{1, 2, 3, 4, 5, 6, 7}, 7, new int[]{1, 2, 3, 4, 5, 6, 7}),
            arguments(new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100})
        );
    }
}