package com.ggwadera.array.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumLengthOfStringAfterDeletingSimilarEndsTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void minimumLength(String s, int expected) {
        var solution = new MinimumLengthOfStringAfterDeletingSimilarEnds();
        assertThat(solution.minimumLength(s)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments("ca", 2),
            arguments("cabaabac", 0),
            arguments("aabccabba", 3)
        );
    }
}