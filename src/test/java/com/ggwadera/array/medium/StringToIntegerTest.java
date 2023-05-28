package com.ggwadera.array.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StringToIntegerTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void myAtoi(String s, int expected) {
        var atoi = new StringToInteger();
        assertThat(atoi.myAtoi(s)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments("42", 42),
            arguments("   -42", -42),
            arguments("4193 with words", 4193),
            arguments("     words -4193", 0),
            arguments("+-12", 0),
            arguments("  +5a3", 5),
            arguments("-5-", -5),
            arguments("-91283472332", Integer.MIN_VALUE),
            arguments("+91283472332", Integer.MAX_VALUE)
        );
    }
}