package com.ggwadera.array.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TestUtils.parseMatrix;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumNumberOfArrowsToBurstBalloonsTest {

    private final MinimumNumberOfArrowsToBurstBalloons solution = new MinimumNumberOfArrowsToBurstBalloons();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void findMinArrowShots(int[][] points, int expected) {
        assertThat(solution.findMinArrowShots(points)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(parseMatrix("[[10,16],[2,8],[1,6],[7,12]]", 4, 2), 2),
            arguments(parseMatrix("[[1,2],[3,4],[5,6],[7,8]]", 4, 2), 4),
            arguments(parseMatrix("[[1,2],[2,3],[3,4],[4,5]]", 4, 2), 2)
        );
    }
}