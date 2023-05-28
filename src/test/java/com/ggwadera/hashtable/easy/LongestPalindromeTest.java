package com.ggwadera.hashtable.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestPalindromeTest {

    private static final LongestPalindrome lp = new LongestPalindrome();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void longestPalindrome(String s, int expected) {
        assertThat(lp.longestPalindrome(s)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments("abccccdd", 7),
            arguments("a", 1),
            arguments("abcbe", 3),
            arguments("ccc", 3)
        );
    }
}