package com.ggwadera.array.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BagOfTokensTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void bagOfTokensScore(int[] tokens, int power, int expectedScore) {
        var solution = new BagOfTokens();
        int actualScore = solution.bagOfTokensScore(tokens, power);
        assertThat(actualScore).isEqualTo(expectedScore);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{100}, 50, 0),
            arguments(new int[]{200, 100}, 150, 1),
            arguments(new int[]{100, 200, 300, 400}, 200, 2),
            arguments(new int[]{71, 55, 82}, 54, 0),
            arguments(new int[]{100, 1, 1, 1}, 5, 3),
            arguments(new int[]{2, 3, 4}, 1, 0)
        );
    }
}