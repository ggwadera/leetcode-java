package com.ggwadera.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MergeSortedArrayTest {

    private static final MergeSortedArray msa = new MergeSortedArray();


    @ParameterizedTest
    @MethodSource("parameterSource")
    void merge(int[] nums1, int m, int[] nums2, int n, int[] expected) {
        msa.merge(nums1, m, nums2, n);
        assertThat(nums1).isEqualTo(expected);
    }

    public static Stream<Arguments> parameterSource() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6}),
                arguments(new int[]{1}, 1, new int[]{}, 0, new int[]{1}),
                arguments(new int[]{0}, 0, new int[]{1}, 1, new int[]{1}),
                arguments(new int[]{1, 2, 3, 4, 0, 0, 0}, 4, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 4, 5, 6}),
                arguments(new int[]{1, 2, 3, 0, 0, 0, 0}, 3, new int[]{2, 5, 6, 8}, 4, new int[]{1, 2, 2, 3, 5, 6, 8}),
                arguments(new int[]{2, 0}, 1, new int[]{1}, 1, new int[]{1, 2})
        );
    }
}