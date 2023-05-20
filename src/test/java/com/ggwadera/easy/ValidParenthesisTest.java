package com.ggwadera.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidParenthesisTest {

    private static final ValidParenthesis vp = new ValidParenthesis();

    @ParameterizedTest
    @MethodSource("parameterProvider")
    void isValid(String s, boolean expected) {
        assertThat(vp.isValid(s)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterProvider() {
        return Stream.of(
                arguments("()", true),
                arguments("()[]{}", true),
                arguments("([{}])", true),
                arguments("(]", false),
                arguments("([)", false),
                arguments("]", false),
                arguments("[", false)
        );
    }
}