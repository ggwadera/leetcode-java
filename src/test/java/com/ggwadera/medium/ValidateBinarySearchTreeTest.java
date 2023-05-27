package com.ggwadera.medium;

import com.ggwadera.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TreeUtils.parseTree;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidateBinarySearchTreeTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void isValidBST(TreeNode root, boolean expected) {
        var bst = new ValidateBinarySearchTree();
        assertThat(bst.isValidBST(root)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(parseTree(2, 1, 3), true),
            arguments(parseTree(5, 1, 4, null, null, 3, 6), false),
            arguments(parseTree(5, 4, 6, null, null, 3, 7), false),
            arguments(parseTree(2, 2, 2), false),
            arguments(parseTree(2147483647), true),
            arguments(parseTree(-2147483648, null, 2147483647), true)
        );
    }
}