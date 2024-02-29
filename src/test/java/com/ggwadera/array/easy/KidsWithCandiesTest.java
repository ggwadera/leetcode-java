package com.ggwadera.array.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KidsWithCandiesTest {


    @ParameterizedTest
    @MethodSource("parameterSource")
    void kidsWithCandies(int[] candies, int extraCandies, List<Boolean> expected) {
        var solution = new KidsWithCandies();
        assertThat(solution.kidsWithCandies(candies, extraCandies)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{2, 3, 5, 1, 3}, 3, List.of(true, true, true, false, true)),
            arguments(new int[]{4, 2, 1, 1, 2}, 1, List.of(true, false, false, false, false)),
            arguments(new int[]{12, 1, 12}, 10, List.of(true, false, true))
        );
    }
}