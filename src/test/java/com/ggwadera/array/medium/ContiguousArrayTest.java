package com.ggwadera.array.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TestUtils.parseArray;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ContiguousArrayTest {

    private final ContiguousArray solution = new ContiguousArray();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void findMaxLength(int[] nums, int expected) {
        assertThat(solution.findMaxLength(nums)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(parseArray("[0,1]"), 2),
            arguments(parseArray("[0,1,0]"), 2),
            arguments(parseArray("[0, 1, 1, 1, 1, 1, 0, 1, 0, 1]"), 4),
            arguments(parseArray("[1, 1, 0, 0, 1, 1, 0, 1, 0, 1]"), 8),
            arguments(parseArray("[0, 0, 0, 1, 1, 0, 0, 1, 1, 0]"), 8),
            arguments(parseArray("[1, 0, 1, 1, 0, 1, 1, 1, 0, 1]"), 4),
            arguments(parseArray("[0, 0, 0, 1, 1, 0, 1, 1, 1, 1]"), 8),
            arguments(parseArray("[1, 0, 0, 0, 1, 1, 0, 1, 1, 0]"), 10)
        );
    }
}