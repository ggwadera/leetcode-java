package com.ggwadera.string.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LengthOfLastWordTest {

    private final LengthOfLastWord solution = new LengthOfLastWord();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void lengthOfLastWord(String s, int expected) {
        assertThat(solution.lengthOfLastWord(s)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments("Hello World", 5),
            arguments("   fly me   to   the moon  ", 4),
            arguments("luffy is still joyboy", 6),
            arguments("a", 1)
        );
    }
}