package com.ggwadera.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RomanToIntegerTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void romanToInt(String s, int expected) {
        var rtoi = new RomanToInteger();
        assertThat(rtoi.romanToInt(s)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments("III", 3),
            arguments("LVIII", 58),
            arguments("MCMXCIV", 1994)
        );
    }
}