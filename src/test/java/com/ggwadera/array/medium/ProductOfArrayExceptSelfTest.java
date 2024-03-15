package com.ggwadera.array.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ProductOfArrayExceptSelfTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void productExceptSelf(int[] nums, int[] expected) {
        var solution = new ProductOfArrayExceptSelf();
        assertThat(solution.productExceptSelf(nums)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
            arguments(new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0})
        );
    }
}