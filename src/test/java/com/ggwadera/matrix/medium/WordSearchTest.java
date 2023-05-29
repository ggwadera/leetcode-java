package com.ggwadera.matrix.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TestUtils.parseCharMatrix;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WordSearchTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void exist(char[][] board, String word, boolean expected) {
        var w = new WordSearch();
        assertThat(w.exist(board, word)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(
                parseCharMatrix("[[A,B,C,E],[S,F,C,S],[A,D,E,E]]", 3, 4),
                "ABCCED",
                true
            ),
            arguments(
                parseCharMatrix("[[A,B,C,E],[S,F,C,S],[A,D,E,E]]", 3, 4),
                "SEE",
                true
            ),
            arguments(
                parseCharMatrix("[[A,B,C,E],[S,F,C,S],[A,D,E,E]]", 3, 4),
                "ABCB",
                false
            )
        );
    }
}