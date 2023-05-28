package com.ggwadera.matrix.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/surrounded-regions">130. Surrounded Regions</a>
 */
public class SurroundedRegions {

    private static final int[][] DIRECTIONS = new int[][]{
        new int[]{ 0,  1},
        new int[]{ 0, -1},
        new int[]{ 1,  0},
        new int[]{-1,  0},
    };

    private int m, n;
    private char[][] board;

    /**
     * Given an m x n matrix board containing 'X' and 'O',
     * capture all regions that are 4-directionally surrounded by 'X'.
     * <p>
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     */
    public void solve(char[][] board) {
        this.board = board;
        m = board.length;
        n = board[0].length;

        /*
         Start a DFS from the borders of the matrix
         All the connected O's will be transformed in #'s
         The O's that remain unchanged are the ones able to convert into X's
         At the ends, go through the matrix replacing #'s with O's and the O's with X's

         For example:
         X X X X           X X X X             X X X X
         X X O X  ->       X X O X    ->       X X X X
         X O X X           X # X X             X O X X
         X O X X           X # X X             X O X X
        */

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(i, 0);
            if (board[i][n - 1] == 'O') dfs(i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(0, j);
            if (board[m - 1][j] == 'O') dfs(m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O')
            return;

        if (board[i][j] == 'O') board[i][j] = '#';
        for (var d : DIRECTIONS) {
            dfs(i + d[0], j + d[1]);
        }
    }

}
