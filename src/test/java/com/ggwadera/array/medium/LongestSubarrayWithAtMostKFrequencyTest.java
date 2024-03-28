package com.ggwadera.array.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TestUtils.parseArray;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestSubarrayWithAtMostKFrequencyTest {

    private final LongestSubarrayWithAtMostKFrequency solution = new LongestSubarrayWithAtMostKFrequency();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void maxSubarrayLength(int[] nums, int k, int expected) {
        assertThat(solution.maxSubarrayLength(nums, k)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(parseArray("[1,2,3,1,2,3,1,2]"), 2, 6),
            arguments(parseArray("[1,2,1,2,1,2,1,2]"), 1, 2),
            arguments(parseArray("[5,5,5,5,5,5,5]"), 4, 4),
            arguments(parseArray("[1,1,1,3]"), 2, 3)
        );
    }
}