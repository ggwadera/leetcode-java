package com.ggwadera.string.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MergeStringsAlternatelyTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void mergeAlternately(String a, String b, String expected) {
        MergeStringsAlternately m = new MergeStringsAlternately();
        assertThat(m.mergeAlternately(a, b)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
                arguments("abc", "pqr", "apbqcr"),
                arguments("ab", "pqrs", "apbqrs"),
                arguments("abcd", "pq", "apbqcd")
        );
    }

}