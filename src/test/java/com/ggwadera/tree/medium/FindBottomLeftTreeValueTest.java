package com.ggwadera.tree.medium;

import com.ggwadera.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ggwadera.utils.TreeUtils.parseTree;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindBottomLeftTreeValueTest {

    @ParameterizedTest
    @MethodSource("parameterProvider")
    void findBottomLeftValue(TreeNode root, int expected) {
        var solution = new FindBottomLeftTreeValue();
        assertThat(solution.findBottomLeftValue(root)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterProvider() {
        return Stream.of(
                arguments(parseTree(2, 1, 3), 1),
                arguments(parseTree(1, 2, 3, 4, null, 5, 6, null, null, 7), 7),
                arguments(parseTree(0), 0),
                arguments(parseTree(0, null, -1), -1)
        );
    }
}