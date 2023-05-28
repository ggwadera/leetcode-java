package com.ggwadera.matrix.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.ggwadera.utils.TestUtils.parseMatrix;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SpiralMatrixTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void spiralOrder(int[][] matrix, List<Integer> expected) {
        var s = new SpiralMatrix();
        assertThat(s.spiralOrder(matrix)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(
                parseMatrix("[[1,2,3],[4,5,6],[7,8,9]]", 3, 3),
                asList(1, 2, 3, 6, 9, 8, 7, 4, 5)
            ),
            arguments(
                parseMatrix("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]", 3, 4),
                asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
            ),
            arguments(
                parseMatrix("[[1,2],[5,6],[9,10]]", 3, 2),
                asList(1, 2, 6, 10, 9, 5)
            )
        );
    }
}