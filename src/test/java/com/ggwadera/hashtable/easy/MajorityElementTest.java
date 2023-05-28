package com.ggwadera.hashtable.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MajorityElementTest {

    private static final MajorityElement m = new MajorityElement();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void majorityElement(int[] nums, int expected) {
        assertThat(m.majorityElement(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameterSource")
    void majorityElementBoyerMoore(int[] nums, int expected) {
        assertThat(m.majorityElementBoyerMoore(nums)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{3, 2, 3}, 3),
            arguments(new int[]{2, 2, 1, 1, 1, 2, 2}, 2),
            arguments(new int[]{7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 7, 7, 7, 7}, 7),
            arguments(new int[]{7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5}, 5)
        );
    }
}