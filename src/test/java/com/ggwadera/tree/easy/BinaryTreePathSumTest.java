package com.ggwadera.tree.easy;

import com.ggwadera.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TreeUtils.parseTree;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BinaryTreePathSumTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void hasPathSum(TreeNode root, int targetSum, boolean expected) {
        var b = new BinaryTreePathSum();
        assertThat(b.hasPathSum(root, targetSum)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(parseTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), 22, true),
            arguments(parseTree(1, 2, 3), 5, false),
            arguments(parseTree(1, 2), 1, false),
            arguments(parseTree(1), 1, true),
            arguments(parseTree(1, 2, null, 3, null, 4, null, 5), 6, false),
            arguments(parseTree(1, -2, -3, 1, 3, -2, null, -1), -1, true),
            arguments(null, 1, false)
        );
    }
}