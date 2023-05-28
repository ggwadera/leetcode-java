package com.ggwadera.array.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SearchInsertionPositionTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void searchInsert(int[] nums, int target, int expected) {
        var s = new SearchInsertionPosition();
        assertThat(s.searchInsert(nums, target)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{1, 3, 5, 6}, 5, 2),
            arguments(new int[]{1, 3, 5, 6}, 2, 1),
            arguments(new int[]{1, 3, 5, 6}, 7, 4)
        );
    }
}