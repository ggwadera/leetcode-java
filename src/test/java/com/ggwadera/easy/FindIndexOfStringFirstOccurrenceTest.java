package com.ggwadera.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindIndexOfStringFirstOccurrenceTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void strStr(String haystack, String needle, int expected) {
        var f = new FindIndexOfStringFirstOccurrence();
        assertThat(f.strStr(haystack, needle)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments("sadbutsad", "sad", 0),
            arguments("leetcode", "leeto", -1)
        );
    }
}