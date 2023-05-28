package com.ggwadera.bit.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SingleNumberTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void singleNumber(int[] nums, int expected) {
        var s = new SingleNumber();
        assertThat(s.singleNumber(nums)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{2, 2, 1}, 1),
            arguments(new int[]{4, 1, 2, 1, 2}, 4),
            arguments(new int[]{1}, 1)
        );
    }
}