package com.ggwadera.array.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoveElementTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void removeElement(int[] nums, int val, int expected, int[] expectedNums) {
        var r = new RemoveElement();
        int k = r.removeElement(nums, val);
        assertThat(k).isEqualTo(expected);
        int[] resultNums = Arrays.copyOfRange(nums, 0, k);
        assertThat(resultNums).containsExactlyInAnyOrder(expectedNums);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(
                new int[]{3, 2, 2, 3},
                3,
                2,
                new int[]{2, 2}
            ),
            arguments(
                new int[]{0, 1, 2, 2, 3, 0, 4, 2},
                2,
                5,
                new int[]{0, 1, 4, 0, 3}
            ),
            arguments(
                new int[]{1},
                3,
                1,
                new int[]{1}
            ),
            arguments(
                new int[]{},
                3,
                0,
                new int[]{}
            ),
            arguments(
                new int[]{3},
                3,
                0,
                new int[]{}
            )
        );
    }
}