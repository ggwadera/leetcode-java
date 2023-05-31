package com.ggwadera.array.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumWindowSubstringTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void minWindow(String s, String t, String expected) {
        var m = new MinimumWindowSubstring();
        assertThat(m.minWindow(s, t)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments("ADOBECODEBANC", "ABC", "BANC"),
            arguments("a", "a", "a"),
            arguments("a", "aa", ""),
            arguments("bba", "ab", "ba")
        );
    }
}