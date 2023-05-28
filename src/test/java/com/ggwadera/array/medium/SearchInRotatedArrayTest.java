package com.ggwadera.array.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SearchInRotatedArrayTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void search(int[] nums, int target, int expected) {
        var s = new SearchInRotatedArray();
        assertThat(s.search(nums, target)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
            arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
            arguments(new int[]{1}, 0, -1),
            arguments(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8, 4),
            arguments(new int[]{1, 3}, 3, 1),
            arguments(new int[]{1, 2, 3, 4, 5, 6}, 4, 3),
            arguments(new int[]{8, 1, 2, 3, 4, 5, 6, 7}, 6, 6),
            arguments(new int[]{5, 1, 2, 3, 4}, 1, 1)
        );
    }
}