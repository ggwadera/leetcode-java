package com.ggwadera.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class FirstBadVersionTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void firstBadVersion(int n, int expected) {
        var f = new FirstBadVersion(expected);
        Assertions.assertThat(f.firstBadVersion(n)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(5, 4),
            arguments(1, 1),
            arguments(3, 2),
            arguments(11, 11)
        );
    }
}