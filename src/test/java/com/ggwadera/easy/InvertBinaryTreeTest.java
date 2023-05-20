package com.ggwadera.easy;

import com.ggwadera.TestUtils;
import com.ggwadera.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.TestUtils.parseTree;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class InvertBinaryTreeTest {

    private static final InvertBinaryTree ibt = new InvertBinaryTree();

    @ParameterizedTest
    @MethodSource("parameterProvider")
    void invertTree(TreeNode root, TreeNode expected) {
        TreeNode inverted = ibt.invertTree(root);
        assertThat(TestUtils.treesAreEqual(inverted, expected)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    void invertTreeIterative(TreeNode root, TreeNode expected) {
        TreeNode inverted = ibt.invertTreeIterative(root);
        assertThat(TestUtils.treesAreEqual(inverted, expected)).isTrue();
    }

    public static Stream<Arguments> parameterProvider() {
        return Stream.of(
            arguments(parseTree(4, 2, 7, 1, 3, 6, 9), parseTree(4, 7, 2, 9, 6, 3, 1)),
            arguments(parseTree(2, 1, 3), parseTree(2, 3, 1)),
            arguments(new TreeNode(), new TreeNode()),
            arguments(null, null)
        );
    }
}