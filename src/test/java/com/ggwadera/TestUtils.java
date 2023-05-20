package com.ggwadera;

public final class TestUtils {

    private TestUtils() {}

    /**
     * Parse a matrix string in the format [[0, 0], [0, 0]]
     * @param matrixString the matrix as a string
     * @param m number of rows
     * @param n number of columns
     * @return the parsed matrix as an array of arrays
     */
    public static int[][] parseMatrix(String matrixString, int m, int n) {
        int[][] matrix = new int[m][n];
        String[] rows = matrixString.replaceAll("[ \\[]", "")
            .replaceAll("],", " ")
            .replaceAll("]", "")
            .split(" ");
        for (int i = 0; i < rows.length; i++) {
            String[] columns = rows[i].split(",");
            for (int j = 0; j < columns.length; j++) {
                matrix[i][j] = Integer.parseInt(columns[j]);
            }
        }
        return matrix;
    }
}
