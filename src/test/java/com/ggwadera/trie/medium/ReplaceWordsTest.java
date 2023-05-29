package com.ggwadera.trie.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReplaceWordsTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void replaceWords(List<String> dictionary, String sentence, String expected) {
        var r = new ReplaceWords();
        assertThat(r.replaceWords(dictionary, sentence)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(
                List.of("cat", "bat", "rat"),
                "the cattle was rattled by the battery",
                "the cat was rat by the bat"
            ),
            arguments(
                List.of("a", "b", "c"),
                "aadsfasf absbs bbab cadsfafs",
                "a a b c"
            )
        );
    }
}