package com.ggwadera.string.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class IsomorphicStringsTest {

    private final IsomorphicStrings solution = new IsomorphicStrings();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void isIsomorphic(String s, String t, boolean expected) {
        assertThat(solution.isIsomorphic(s, t)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments("egg", "add", true),
            arguments("foo", "bar", false),
            arguments("paper", "title", true),
            arguments("badc", "baba", false)
        );
    }
}