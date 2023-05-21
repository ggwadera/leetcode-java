package com.ggwadera.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RansomNoteTest {

    private static final RansomNote r = new RansomNote();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void canConstruct(String ransomNote, String magazine, boolean expected) {
        assertThat(r.canConstruct(ransomNote, magazine)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments("a", "b", false),
            arguments("aa", "ab", false),
            arguments("aa", "aab", true)
        );
    }
}