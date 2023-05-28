package com.ggwadera.math.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PowTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void myPow(double x, int n, double expected) {
        var pow = new Pow();
        assertThat(pow.myPow(x, n)).isCloseTo(expected, offset(1e-5));
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(2.0, 10, 1024.0),
            arguments(2.1, 3, 9.261),
            arguments(2.0, -2, 0.25),
            arguments(1.0, Integer.MAX_VALUE, 1.0),
            arguments(2.0, Integer.MIN_VALUE, 0.0)
        );
    }
}