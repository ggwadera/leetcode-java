package com.ggwadera.array.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidPalindromeTest {

    private static final ValidPalindrome vp = new ValidPalindrome();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void isPalindrome(String s, boolean expected) {
        assertThat(vp.isPalindrome(s)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
                arguments("A man, a plan, a canal: Panama", true),
                arguments("race a car", false),
                arguments(" ", true),
                arguments("0P", false)
        );
    }
}