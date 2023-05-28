package com.ggwadera.matrix.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TestUtils.parseMatrix;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ZeroOneMatrixTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void updateMatrixBFS(int[][] matrix, int[][] expected) {
        var z = new ZeroOneMatrix();
        assertThat(z.updateMatrixBFS(matrix)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameterSource")
    void updateMatrixDP(int[][] matrix, int[][] expected) {
        var z = new ZeroOneMatrix();
        assertThat(z.updateMatrixDP(matrix)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(
                parseMatrix("[[0,0,0],[0,1,0],[0,0,0]]", 3, 3),
                parseMatrix("[[0,0,0],[0,1,0],[0,0,0]]", 3, 3)
            ),
            arguments(
                parseMatrix("[[0,0,0],[0,1,0],[1,1,1]]", 3, 3),
                parseMatrix("[[0,0,0],[0,1,0],[1,2,1]]", 3, 3)
            )
        );
    }
}