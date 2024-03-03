package com.ggwadera.array.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindTheHighestAltitudeTest {


    @ParameterizedTest
    @MethodSource("parameterSource")
    void largestAltitude(int[] gain, int expected) {
        var solution = new FindTheHighestAltitude();
        assertThat(solution.largestAltitude(gain)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{-5, 1, 5, 0, -7}, 1),
            arguments(new int[]{-4, -3, -2, -1, 4, 3, 2}, 0)
        );
    }
}