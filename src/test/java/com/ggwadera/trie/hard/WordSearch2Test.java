package com.ggwadera.trie.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.ggwadera.utils.TestUtils.parseCharMatrix;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WordSearch2Test {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void findWords(char[][] board, String[] words, List<String> expected) {
        var w = new WordSearch2();
        assertThat(w.findWords(board, words)).containsExactlyInAnyOrderElementsOf(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(
                parseCharMatrix("[[o,a,a,n],[e,t,a,e],[i,h,k,r],[i,f,l,v]]", 4, 4),
                new String[]{"oath", "pea", "eat", "rain"},
                List.of("oath", "eat")
            ),
            arguments(
                parseCharMatrix("[[a,b],[c,d]]", 2, 2),
                new String[]{"abcb"},
                List.of()
            )
        );
    }
}