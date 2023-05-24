package com.ggwadera.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DailyTemperaturesTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void dailyTemperatures(int[] temperatures, int[] expected) {
        var d = new DailyTemperatures();
        assertThat(d.dailyTemperatures(temperatures)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(
                new int[]{73, 74, 75, 71, 69, 72, 76, 73},
                new int[]{1, 1, 4, 2, 1, 1, 0, 0}),
            arguments(
                new int[]{30, 40, 50, 60},
                new int[]{1, 1, 1, 0}),
            arguments(
                new int[]{30, 60, 90},
                new int[]{1, 1, 0})
        );
    }
}