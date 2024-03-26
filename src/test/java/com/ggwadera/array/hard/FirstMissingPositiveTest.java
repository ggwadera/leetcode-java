package com.ggwadera.array.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TestUtils.parseArray;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FirstMissingPositiveTest {

    private final FirstMissingPositive solution = new FirstMissingPositive();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void firstMissingPositive(int[] nums, int expected) {
        assertThat(solution.firstMissingPositive(nums)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(parseArray("[1,2,0]"), 3),
            arguments(parseArray("[3,4,-1,1]"), 2),
            arguments(parseArray("[7,8,9,11,12]"), 1),
            arguments(parseArray("[0,1,2]"), 3)
        );
    }
}