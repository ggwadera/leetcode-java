package com.ggwadera.array.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountElementsWithMaxFrequencyTest {

    private final CountElementsWithMaxFrequency solution = new CountElementsWithMaxFrequency();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void maxFrequencyElements(int[] nums, int expected) {
        assertThat(solution.maxFrequencyElements(nums)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{1, 2, 2, 3, 1, 4}, 4),
            arguments(new int[]{1, 2, 3, 4, 5}, 5),
            arguments(new int[]{81, 81, 81, 81, 81, 81, 81, 17, 28, 81, 81, 56, 81, 54, 81, 81, 81, 81, 81, 60, 81, 28, 81, 81, 81, 81, 81, 54, 81, 81, 81, 81, 100, 28}, 25)
        );
    }
}