package com.ggwadera.array.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestCommonPrefixTest {

    private final LongestCommonPrefix solution = new LongestCommonPrefix();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void longestCommonPrefix(String[] strs, String expected) {
        assertThat(solution.longestCommonPrefix(strs)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameterSource")
    void longestCommonPrefixVertical(String[] strs, String expected) {
        assertThat(solution.longestCommonPrefixVertical(strs)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new String[]{"flower", "flow", "flight"}, "fl"),
            arguments(new String[]{"dog", "racecar", "car"}, ""),
            arguments(new String[]{"ab", "a"}, "a")
        );
    }
}