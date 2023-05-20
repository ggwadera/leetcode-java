package com.ggwadera.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.TestUtils.parseMatrix;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FloodFillTest {

    private static final FloodFill ff = new FloodFill();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void floodFill(int[][] image, int sr, int sc, int newColor, int[][] expected) {
        assertThat(ff.floodFill(image, sr, sc, newColor)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(parseMatrix("[[1,1,1],[1,1,0],[1,0,1]]", 3, 3), 1, 1, 2, parseMatrix("[[2,2,2],[2,2,0],[2,0,1]]", 3, 3)),
            arguments(parseMatrix("[[0,0,0],[0,0,0]]", 2, 3), 0, 0, 0, parseMatrix("[[0,0,0],[0,0,0]]", 2, 3))
        );
    }
}