package com.ggwadera.trie.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WordBreakTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void wordBreak(String s, List<String> wordDict, boolean expected) {
        var w = new WordBreak();
        assertThat(w.wordBreak(s, wordDict)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(
                "leetcode",
                List.of("leet", "code"),
                true
            ),
            arguments(
                "applepenapple",
                List.of("apple", "pen"),
                true
            ),
            arguments(
                "catsandog",
                List.of("cats", "dog", "sand", "and", "cat"),
                false
            ),
            arguments(
                "catsanddog",
                List.of("cats", "dog", "sand", "and", "cat"),
                true
            ),
            arguments(
                "aaaaaaa",
                List.of("aaaa", "aaa"),
                true
            ),
            arguments(
                "aaaaaaa",
                List.of("aaaa", "aa"),
                false
            ),
            arguments(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"),
                false
            ),
            arguments(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                List.of("aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa", "ba"),
                false
            )
        );
    }

}