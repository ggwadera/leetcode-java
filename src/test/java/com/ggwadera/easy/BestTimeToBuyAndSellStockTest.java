package com.ggwadera.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BestTimeToBuyAndSellStockTest {

    private static final BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();

    @ParameterizedTest
    @MethodSource("parameterSource")
    void maxProfit(int[] prices, int expected) {
        assertThat(b.maxProfit(prices)).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
                arguments(new int[]{7, 1, 5, 3, 6, 4}, 5),
                arguments(new int[]{7, 6, 4, 3, 1}, 0),
                arguments(new int[]{1}, 0),
                arguments(new int[]{2, 4, 1}, 2)
        );
    }
}