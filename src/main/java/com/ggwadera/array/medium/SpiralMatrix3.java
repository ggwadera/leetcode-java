package com.ggwadera.array.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/spiral-matrix-iii">Spiral Matrix III</a>
 */
public class SpiralMatrix3 {

    enum Direction {
        LEFT(0, -1, 1, 2),
        RIGHT(0, 1, 1, 3),
        UP(-1, 0, 0, 1),
        DOWN(1, 0, 0, 0);

        private static final Direction[] dirs = new Direction[]{LEFT, RIGHT, UP, DOWN};

        final int x, y, addStep;
        private final int next;

        Direction(int x, int y, int addStep, int next) {
            this.x = x;
            this.y = y;
            this.addStep = addStep;
            this.next = next;
        }

        Direction getNext() {
            return dirs[this.next];
        }
    }

    /**
     * You start at the cell (rStart, cStart) of an rows x cols grid facing east.
     * The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.
     * <p>
     * You will walk in a clockwise spiral shape to visit every position in this grid.
     * Whenever you move outside the grid's boundary, we continue our walk outside the grid
     * (but may return to the grid boundary later.).
     * Eventually, we reach all rows * cols spaces of the grid.
     * <p>
     * Return an array of coordinates representing the positions of the grid in the order you visited them.
     */
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        final int[][] coords = new int[rows * cols][2];
        Direction direction = Direction.RIGHT;
        int i = 0;
        int r = rStart, c = cStart;
        int stepsToWalk = 1, steps = 0;

        while (i < rows * cols) {
            if (r >= 0 && r < rows && c >= 0 && c < cols) {
                coords[i][0] = r;
                coords[i][1] = c;
                i++;
            }
            r += direction.x;
            c += direction.y;
            if (++steps == stepsToWalk) {
                steps = 0;
                direction = direction.getNext();
                stepsToWalk += direction.addStep;
            }
        }

        return coords;
    }

}
