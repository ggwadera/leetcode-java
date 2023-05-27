package com.ggwadera.medium;

import com.ggwadera.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TreeUtils.parseTree;
import static com.ggwadera.utils.TreeUtils.treesAreEqual;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BinaryTreeFromPreorderAndInorderTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void buildTree(int[] preorder, int[] inorder, TreeNode expected) {
        var b = new BinaryTreeFromPreorderAndInorder();
        var root = b.buildTree(preorder, inorder);
        assertThat(treesAreEqual(root, expected)).isTrue();
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}, parseTree(3, 9, 20, null, null, 15, 7)),
            arguments(new int[]{-1}, new int[]{-1}, parseTree(-1))
        );
    }
}