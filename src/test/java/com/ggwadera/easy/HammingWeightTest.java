package com.ggwadera.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class HammingWeightTest {

    private static final HammingWeight hw = new HammingWeight();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void hammingWeight(int n, int expected) {
        Assertions.assertThat(hw.hammingWeight(n)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(0b00000000000000000000000000001011, 3),
            arguments(0b00000000000000000000000010000000, 1),
            arguments(0b00000000000000000000000000000000, 0),
            arguments(0b11111111111111111111111111111101, 31)
        );
    }
}