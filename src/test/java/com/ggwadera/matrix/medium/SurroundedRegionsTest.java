package com.ggwadera.matrix.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TestUtils.parseCharMatrix;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SurroundedRegionsTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void solve(char[][] board, char[][] expected) {
        var s = new SurroundedRegions();
        s.solve(board);
        assertThat(board).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(
                parseCharMatrix("[[X,X,X,X],[X,O,O,X],[X,X,O,X],[X,O,X,X]]", 4, 5),
                parseCharMatrix("[[X,X,X,X],[X,X,X,X],[X,X,X,X],[X,O,X,X]]", 4, 5)
            ),
            arguments(
                parseCharMatrix("[[X]]", 1, 1),
                parseCharMatrix("[[X]]", 1, 1)
            ),
            arguments(
                parseCharMatrix("[[X,X,X,X],[X,O,O,X],[X,O,O,X],[X,O,X,X]]", 4, 5),
                parseCharMatrix("[[X,X,X,X],[X,O,O,X],[X,O,O,X],[X,O,X,X]]", 4, 5)
            ),
            arguments(
                parseCharMatrix("[[O,O,O,O,X,X],[O,O,O,O,O,O],[O,X,O,X,O,O],[O,X,O,O,X,O],[O,X,O,X,O,O],[O,X,O,O,O,O]]", 6, 6),
                parseCharMatrix("[[O,O,O,O,X,X],[O,O,O,O,O,O],[O,X,O,X,O,O],[O,X,O,O,X,O],[O,X,O,X,O,O],[O,X,O,O,O,O]]", 6, 6)
            ),
            arguments(
                parseCharMatrix("[[X,O,X,O,X,O],[O,X,O,X,O,X],[X,O,X,O,X,O],[O,X,O,X,O,X]]", 4, 6),
                parseCharMatrix("[[X,O,X,O,X,O],[O,X,X,X,X,X],[X,X,X,X,X,O],[O,X,O,X,O,X]]", 4, 6)
            )
        );
    }
}