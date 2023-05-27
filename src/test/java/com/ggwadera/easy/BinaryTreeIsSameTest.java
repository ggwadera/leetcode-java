package com.ggwadera.easy;

import com.ggwadera.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TreeUtils.parseTree;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BinaryTreeIsSameTest {

    @ParameterizedTest
    @MethodSource("parameterSource")
    void isSameTree(TreeNode p, TreeNode q, boolean expected) {
        var b = new BinaryTreeIsSame();
        assertThat(b.isSameTree(p, q)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
            arguments(parseTree(1, 2, 3), parseTree(1, 2, 3), true),
            arguments(parseTree(1, 2), parseTree(1, null, 2), false),
            arguments(parseTree(1, 2, 1), parseTree(1, 1, 2), false)
        );
    }

}