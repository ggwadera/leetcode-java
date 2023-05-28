package com.ggwadera.hashtable.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TwoSumTest {

    private static final TwoSum ts = new TwoSum();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void twoSum(int[] nums, int target, int[] expected) {
        assertThat(ts.twoSum(nums, target)).containsExactlyInAnyOrder(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
                arguments(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                arguments(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                arguments(new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }
}