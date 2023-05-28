package com.ggwadera.tree.medium;

import com.ggwadera.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TreeUtils.parseTree;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LowestCommonAncestorTest {

    private static final LowestCommonAncestor lca = new LowestCommonAncestor();

    @ParameterizedTest
    @MethodSource("parameterProvider")
    void lowestCommonAncestor(TreeNode root, TreeNode pNode, TreeNode qNode, TreeNode expected) {
        assertThat(lca.lowestCommonAncestor(root, pNode, qNode).val).isEqualTo(expected.val);
    }

    public static Stream<Arguments> parameterProvider() {
        return Stream.of(
            arguments(parseTree(6,2,8,0,4,7,9,null,null,3,5), new TreeNode(2), new TreeNode(8), new TreeNode(6)),
            arguments(parseTree(6,2,8,0,4,7,9,null,null,3,5), new TreeNode(2), new TreeNode(4), new TreeNode(2)),
            arguments(parseTree(2,1), new TreeNode(2), new TreeNode(1), new TreeNode(2)),
            arguments(parseTree(3,1,4,null,2), new TreeNode(2), new TreeNode(3), new TreeNode(3))
        );
    }
}