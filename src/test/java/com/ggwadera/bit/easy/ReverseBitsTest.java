package com.ggwadera.bit.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReverseBitsTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void reverseBits(int n, int expected) {
        var r = new ReverseBits();
        assertThat(r.reverseBits(n)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(0b00000010100101000001111010011100, 0b00111001011110000010100101000000),
            arguments(0b11111111111111111111111111111101, 0b10111111111111111111111111111111)
        );
    }
}