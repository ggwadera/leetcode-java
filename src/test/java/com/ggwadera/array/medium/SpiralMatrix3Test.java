package com.ggwadera.array.medium;

import com.ggwadera.utils.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SpiralMatrix3Test {

    private final SpiralMatrix3 solution = new SpiralMatrix3();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void spiralMatrixIII(int rows, int cols, int rowStart, int colStart, int[][] expected) {
        assertThat(solution.spiralMatrixIII(rows, cols, rowStart, colStart)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(1, 4, 0, 0, TestUtils.parseMatrix("[[0,0],[0,1],[0,2],[0,3]]", 4, 2)),
            arguments(5, 6, 1, 4, TestUtils.parseMatrix("[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]", 5 * 6, 2))
        );
    }
}