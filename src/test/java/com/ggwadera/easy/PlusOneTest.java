package com.ggwadera.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PlusOneTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void plusOne(int[] digits, int[] expected) {
        var p = new PlusOne();
        assertThat(p.plusOne(digits)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
            arguments(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2}),
            arguments(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2}),
            arguments(new int[]{9}, new int[]{1, 0}),
            arguments(new int[]{9, 9, 9, 9, 9, 9}, new int[]{1, 0, 0, 0, 0, 0, 0}),
            arguments(new int[]{9, 9, 9, 0, 9, 9}, new int[]{9, 9, 9, 1, 0, 0})
        );
    }

}