package com.ggwadera.matrix.medium;

public class WordSearch {

    private final int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    private int m, n;
    private char[][] board;
    private int len;

    /**
     * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
     * <p>
     * The word can be constructed from letters of sequentially adjacent cells,
     * where adjacent cells are horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
     */
    public boolean exist(char[][] board, String word) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        len = word.length();

        if (m * n < len) return false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * DFS to traverse the matrix and search for the word
     */
    private boolean check(int i, int j, int k, String word) {
        if (k == len) return true;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (board[i][j] != word.charAt(k)) return false;
        board[i][j] ^= '#'; // Mark this position as visited
        boolean found = false;
        for (int[] d : dirs) {
            found |= check(i + d[0], j + d[1], k + 1, word);
        }
        board[i][j] ^= '#'; // Restore the element to the original value
        return found;
    }

}
