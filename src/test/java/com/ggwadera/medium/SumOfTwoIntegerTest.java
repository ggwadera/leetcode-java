package com.ggwadera.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class SumOfTwoIntegerTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void getSum(int a, int b, int expected) {
        var s = new SumOfTwoInteger();
        Assertions.assertThat(s.getSum(a, b)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(1, 2, 3),
            arguments(2, 2, 4),
            arguments(20, 30, 50),
            arguments(-20, -30, -50),
            arguments(Integer.MAX_VALUE, Integer.MIN_VALUE, -1)
        );
    }
}