package com.ggwadera.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BinarySearchTest {

    private static final BinarySearch bs = new BinarySearch();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void search(int[] nums, int target, int expected) {
        assertThat(bs.search(nums, target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameterSource")
    void searchRecursive(int[] nums, int target, int expected) {
        assertThat(bs.searchRecursive(nums, target)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
                arguments(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
                arguments(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1),
                arguments(new int[]{-1, 0, 3, 5, 9, 12, 13}, 9, 4),
                arguments(new int[]{5}, 5, 0),
                arguments(new int[]{5}, 1, -1)
        );
    }
}