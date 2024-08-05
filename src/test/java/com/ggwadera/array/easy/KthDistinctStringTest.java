package com.ggwadera.array.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KthDistinctStringTest {

    private final KthDistinctString solution = new KthDistinctString();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void kthDistinctString(String[] arr, int k, String expected) {
        assertThat(solution.kthDistinct(arr, k)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new String[]{"d", "b", "c", "b", "c", "a"}, 2, "a"),
            arguments(new String[]{"aaa", "aa", "a"}, 1, "aaa"),
            arguments(new String[]{"a", "b", "a"}, 3, "")
        );
    }
}