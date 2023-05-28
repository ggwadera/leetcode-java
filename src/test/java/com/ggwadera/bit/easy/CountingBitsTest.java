package com.ggwadera.bit.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountingBitsTest {

    private static final CountingBits cb = new CountingBits();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void countBits(int n, int[] expected) {
        assertThat(cb.countBits(n)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(2, new int[]{0, 1, 1}),
            arguments(5, new int[]{0, 1, 1, 2, 1, 2}),
            arguments(50, new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3})
        );
    }
}