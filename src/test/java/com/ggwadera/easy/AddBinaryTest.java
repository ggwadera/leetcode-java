package com.ggwadera.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AddBinaryTest {

    private static final AddBinary solution = new AddBinary();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void addBinary(String a, String b, String expected) {
        assertThat(solution.addBinary(a, b)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments("11", "1", "100"),
            arguments("1010", "1011", "10101"),
            arguments("0", "0", "0"),
            // Test for overflow
            arguments(
                "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011",
                "110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000"
            )
        );
    }
}