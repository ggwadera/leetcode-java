package com.ggwadera.matrix.medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Solution for <a href="https://leetcode.com/problems/01-matrix">542. 01 Matrix</a>
 */
public class ZeroOneMatrix {

    record Pair(int i, int j) {}

    private final int[][] directions = new int[][]{
        new int[]{0, 1},
        new int[]{0, -1},
        new int[]{1, 0},
        new int[]{-1, 0},
    };

    private static final int INF = 10_000;

    /**
     * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
     * <p>
     * The distance between two adjacent cells is 1.
     * <p>
     * Solved by BFS
     */
    public int[][] updateMatrixBFS(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<Pair> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    // BFS on 0's
                    q.add(new Pair(i, j));
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        while (!q.isEmpty()) {
            var curr = q.remove();
            for (var d : directions) {
                int i = curr.i() + d[0];
                int j = curr.j() + d[1];
                if (i >= 0 && i < m && j >= 0 && j < n) {
                    if (dist[i][j] > dist[curr.i()][curr.j()] + 1) {
                        dist[i][j] = dist[curr.i()][curr.j()] + 1;
                        q.add(new Pair(i, j));
                    }
                }
            }
        }

        return dist;
    }

    /**
     * Solved by Dynamic Programming, with 2 passes.
     * First pass top to bottom, left to right.
     * Second pass bottom to top, right to left.
     */
    public int[][] updateMatrixDP(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];

        // Top to bottom, left to right
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    dist[i][j] = INF;
                    if (i > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                    }
                }
            }
        }

        // Bottom to top, right to left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                }
                if (j < n - 1) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                }
            }
        }

        return dist;
    }
}
