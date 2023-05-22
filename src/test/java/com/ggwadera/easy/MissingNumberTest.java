package com.ggwadera.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MissingNumberTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void missingNumber(int[] nums, int expected) {
        var mb = new MissingNumber();
        assertThat(mb.missingNumber(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameterSource")
    void missingNumberSum(int[] nums, int expected) {
        var mb = new MissingNumber();
        assertThat(mb.missingNumberSum(nums)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{3, 0, 1}, 2),
            arguments(new int[]{0, 1}, 2),
            arguments(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}, 8)
        );
    }

}