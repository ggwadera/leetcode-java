package com.ggwadera.easy;

import com.ggwadera.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.ggwadera.utils.TreeUtils.parseTree;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BinaryTreeInOrderTraversalTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void inorderTraversal(TreeNode root, List<Integer> expected) {
        var b = new BinaryTreeInOrderTraversal();
        assertThat(b.inorderTraversal(root)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameterSource")
    void iterativeInorderTraversal(TreeNode root, List<Integer> expected) {
        var b = new BinaryTreeInOrderTraversal();
        assertThat(b.iterativeInorderTraversal(root)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(parseTree(1, null, 2, 3), List.of(1, 3, 2)),
            arguments(null, List.of()),
            arguments(new TreeNode(1), List.of(1)),
            arguments(parseTree(5, 4, 7, 2, 3, 6, 8, 1), List.of(1, 2, 4, 3, 5, 6, 7, 8))
        );
    }
}