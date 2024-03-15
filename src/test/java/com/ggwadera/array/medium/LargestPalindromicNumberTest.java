package com.ggwadera.array.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LargestPalindromicNumberTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void largestPalindromic(String num, String expected) {
        var solution = new LargestPalindromicNumber();
        assertThat(solution.largestPalindromic(num)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments("444947137", "7449447"),
            arguments("00009", "9")
        );
    }
}