package com.ggwadera.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestSubstringWithoutRepeatingCharactersTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void lengthOfLongestSubstring(String s, int expected) {
        var l = new LongestSubstringWithoutRepeatingCharacters();
        assertThat(l.lengthOfLongestSubstring(s)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments("abcabcbb", 3),
            arguments("bbbbb", 1),
            arguments("pwwkew", 3)
        );
    }
}