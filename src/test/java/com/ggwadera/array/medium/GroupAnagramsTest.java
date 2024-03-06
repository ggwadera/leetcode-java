package com.ggwadera.array.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GroupAnagramsTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void groupAnagrams(String[] strs, List<List<String>> expected) {
        var solution = new GroupAnagrams();
        assertThat(solution.groupAnagrams(strs)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                List.of(List.of("eat", "tea", "ate"), List.of("bat"), List.of("tan", "nat"))
            ),
            arguments(
                new String[]{""},
                List.of(List.of(""))
            ),
            arguments(
                new String[]{"a"},
                List.of(List.of("a"))
            )
        );
    }
}