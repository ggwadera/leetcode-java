package com.ggwadera.array.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumOddBinaryNumberTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void maximumOddBinaryNumber(String s, String expected) {
        var solution = new MaximumOddBinaryNumber();
        assertThat(solution.maximumOddBinaryNumber(s)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments("010", "001"),
            arguments("0101", "1001"),
            arguments("01001010", "11000001"),
            arguments("1", "1")
        );
    }
}