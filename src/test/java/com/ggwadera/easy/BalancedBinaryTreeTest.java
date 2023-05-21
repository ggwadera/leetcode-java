package com.ggwadera.easy;

import com.ggwadera.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.TestUtils.parseTree;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BalancedBinaryTreeTest {

    private static final BalancedBinaryTree b = new BalancedBinaryTree();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void isBalanced(TreeNode root, boolean expected) {
        assertThat(b.isBalanced(root)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(parseTree(3,9,20,null,null,15,7), true),
            arguments(parseTree(1,2,2,3,3,null,null,4,4), false),
            arguments(parseTree(1,2,2,3,null,null,3,4,null,null,4), false),
            arguments(null, true)
        );
    }

}