package com.ggwadera.math.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SqrtTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void mySqrt(int x, int expected) {
        var sqrt = new Sqrt();
        assertThat(sqrt.mySqrt(x)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(4, 2),
            arguments(8, 2)
        );
    }
}