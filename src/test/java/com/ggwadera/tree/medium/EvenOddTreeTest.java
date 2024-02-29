package com.ggwadera.tree.medium;

import com.ggwadera.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TreeUtils.parseTree;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class EvenOddTreeTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void isEvenOddTree(TreeNode root, boolean expected) {
        var solution = new EvenOddTree();
        assertThat(solution.isEvenOddTree(root)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(parseTree(1,10,4,3,null,7,9,12,8,6,null,null,2), true),
            arguments(parseTree(5,4,2,3,3,7), false),
            arguments(parseTree(5,9,1,3,5,7), false)
        );
    }
}