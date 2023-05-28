package com.ggwadera.matrix.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for <a href="https://leetcode.com/problems/spiral-matrix">54. Spiral Matrix</a>
 */
public class SpiralMatrix {

    private static final int[][] DIRECTIONS = new int[][]{
        new int[]{ 0,  1}, // 0 - RIGHT
        new int[]{ 1,  0}, // 1 - DOWN
        new int[]{ 0, -1}, // 2 - LEFT
        new int[]{-1,  0}  // 3 - UP
    };

    /**
     * Given an m x n matrix, return all elements of the matrix in spiral order.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        final List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        // Start moving to the right
        int direction = 0;

        // Start on the position to the left of the first element
        int[] pos = new int[]{0, -1};

        // Total count of elements
        int count = m * n;

        // Loop until every element was added to the list
        while (count > 0) {
            boolean isMovingHorizontally = direction % 2 == 0;

            // If moving horizontally, walk n steps (columns), else walk m steps (rows)
            int steps = isMovingHorizontally ? n : m;

            for (int i = 0; i < steps; i++) {
                count--;

                // Increment the position according to the direction we're moving
                pos[0] += DIRECTIONS[direction][0];
                pos[1] += DIRECTIONS[direction][1];

                // Add the element of this position to the list
                result.add(matrix[pos[0]][pos[1]]);
            }

            // If moving horizontally decrement the number of rows, so the next loop stays in bound
            if (isMovingHorizontally) m--;
            // Else, decrement the number of columns
            else n--;

            // Update the direction, looping back to 0 when direction == 4;
            direction = (direction + 1) % 4;
        }
        return result;
    }
}
