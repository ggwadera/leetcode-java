package com.ggwadera.tree.easy;

import com.ggwadera.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TreeUtils.parseTree;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BinaryTreeMaxDepthTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void maxDepth(TreeNode root, int expected) {
        var b = new BinaryTreeMaxDepth();
        assertThat(b.maxDepth(root)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(parseTree(3, 9, 20, null, null, 15, 7), 3),
            arguments(parseTree(1, null, 2), 2)
        );
    }
}