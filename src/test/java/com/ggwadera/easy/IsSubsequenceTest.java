package com.ggwadera.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class IsSubsequenceTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void isSubsequence(String s, String t, boolean expected) {
        var solution = new IsSubsequence();
        assertThat(solution.isSubsequence(s, t)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments("abc", "ahbgdc", true),
            arguments("axc", "ahbgdc", false),
            arguments("", "ahbgdc", true),
            arguments("abc", "", false)
        );
    }
}