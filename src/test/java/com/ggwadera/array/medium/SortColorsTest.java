package com.ggwadera.array.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SortColorsTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void sortColors(int[] nums, int[] expected) {
        var s = new SortColors();
        s.sortColors(nums);
        assertThat(nums).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2}),
            arguments(new int[]{2, 0, 1}, new int[]{0, 1, 2}),
            arguments(new int[]{0, 2, 1}, new int[]{0, 1, 2}),
            arguments(new int[]{1, 0, 1}, new int[]{0, 1, 1})
        );
    }
}