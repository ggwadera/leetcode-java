package com.ggwadera.array.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindPeakElementTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void findPeakElement(int[] array, int expected) {
        var solution = new FindPeakElement();
        assertThat(solution.findPeakElement(array)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{1, 2, 3, 1}, 2),
            arguments(new int[]{1, 2, 1, 3, 5, 6, 4}, 5)
        );
    }
}