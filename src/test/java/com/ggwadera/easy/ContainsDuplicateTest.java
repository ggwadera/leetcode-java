package com.ggwadera.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ContainsDuplicateTest {

    private static final ContainsDuplicate c = new ContainsDuplicate();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void containsDuplicate(int[] nums, boolean expected) {
        assertThat(c.containsDuplicate(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameterSource")
    void containsDuplicateSorted(int[] nums, boolean expected) {
        assertThat(c.containsDuplicateSorted(nums)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{1, 2, 3, 1}, true),
            arguments(new int[]{1, 2, 3, 4}, false),
            arguments(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }
}