package com.ggwadera.graph.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TestUtils.parseCharMatrix;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfIslandsTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void numIslands(char[][] grid, int expected) {
        var n = new NumberOfIslands();
        assertThat(n.numIslands(grid)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(parseCharMatrix("[[1,1,1,1,0],[1,1,0,1,0],[1,1,0,0,0],[0,0,0,0,0]]", 4, 5), 1),
            arguments(parseCharMatrix("[[1,1,0,0,0],[1,1,0,0,0],[0,0,1,0,0],[0,0,0,1,1]]", 4, 5), 3),
            arguments(parseCharMatrix("[[1,1,1],[0,1,0],[1,1,1]]", 3, 3), 1)
        );
    }
}