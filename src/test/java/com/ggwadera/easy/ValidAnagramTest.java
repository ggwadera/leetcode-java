package com.ggwadera.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidAnagramTest {

    private static final ValidAnagram va = new ValidAnagram();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void isAnagram(String s, String t, boolean expected) {
        assertThat(va.isAnagram(s, t)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameterSource")
    void isAnagramStream(String s, String t, boolean expected) {
        assertThat(va.isAnagramStream(s, t)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
                arguments("anagram", "nagaram", true),
                arguments("rat", "car", false),
                arguments("tacocat", "cattaco", true),
                arguments("a", "ab", false)
        );
    }
}