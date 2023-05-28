package com.ggwadera.tree.easy;

import com.ggwadera.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TreeUtils.parseTree;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BinaryTreeIsSymmetricTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void isSymmetric(TreeNode root, boolean expected) {
        var b = new BinaryTreeIsSymmetric();
        assertThat(b.isSymmetric(root)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(parseTree(1, 2, 2, 3, 4, 4, 3), true),
            arguments(parseTree(1, 2, 2, null, 3, null, 3), false)
        );
    }
}