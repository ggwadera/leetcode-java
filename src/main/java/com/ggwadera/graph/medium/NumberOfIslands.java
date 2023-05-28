package com.ggwadera.graph.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/number-of-islands">200. Number of Islands</a>
 */
public class NumberOfIslands {

    private int m, n;
    private char[][] grid;

    /**
     * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
     * return the number of islands.
     * <p>
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     */
    public int numIslands(char[][] grid) {
        int islands = 0;
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;

        // Iterate through the entire grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If found land, start a DFS traversal to mark all connected edges
                if (grid[i][j] == '1') {
                    dfs(i, j);

                    // For every graph traversal, it means that there is another isolated island
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(int i, int j) {
        if (
            i < 0 || i == m ||
                j < 0 || j == n ||
                grid[i][j] != '1'
        ) {
            return;
        }
        // Mark the current vertice as visited
        grid[i][j] = '2';

        // Resume the search in all directions, until visiting every edge
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }

}
