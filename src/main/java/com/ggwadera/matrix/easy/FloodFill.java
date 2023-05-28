package com.ggwadera.matrix.easy;

/**
 * Solution for <a href="https://leetcode.com/problems/flood-fill">733. Flood Fill</a>
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            fill(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0
            || sr >= image.length
            || sc < 0
            || sc >= image[0].length) {
            return;
        }

        if (color != image[sr][sc]) return;
        image[sr][sc] = newColor;

        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
    }

}
