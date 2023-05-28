package com.ggwadera.array.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoveDuplicatesFromSortedArrayIITest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void removeDuplicates(int[] nums, int expected, int[] expectedNums) {
        var r = new RemoveDuplicatesFromSortedArrayII();
        int k = r.removeDuplicates(nums);
        assertThat(k).isEqualTo(expected);
        assertThat(Arrays.copyOfRange(nums, 0, k)).isEqualTo(expectedNums);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(
                new int[]{1, 1, 1, 2, 2, 3},
                5,
                new int[]{1, 1, 2, 2, 3}
            ),
            arguments(
                new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3},
                7,
                new int[]{0, 0, 1, 1, 2, 3, 3}
            )
        );
    }
}