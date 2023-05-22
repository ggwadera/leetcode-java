package com.ggwadera.easy;

import com.ggwadera.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TreeUtils.parseTree;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DiameterOfBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void diameterOfBinaryTree(TreeNode root, int expected) {
        final DiameterOfBinaryTree dbt = new DiameterOfBinaryTree();
        assertThat(dbt.diameterOfBinaryTree(root)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            // Max diameter includes the root
            arguments(parseTree(1, 2, 3, 4, 5), 3),
            arguments(parseTree(1, 2), 1),
            // Max diameter does not include the root
            arguments(parseTree(1, 2, 3, 4, 5, null, null, 6, 7, 8, 9, 10, 11, null, null, 12, 13), 6)
        );
    }
}