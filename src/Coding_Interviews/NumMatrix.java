package Coding_Interviews;

public class NumMatrix {
    int[][] matrix;
    int[][] prev;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        prev = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int cur = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                cur += matrix[i][j];
                prev[i][j] = cur + (i > 0 ? prev[i - 1][j] : 0);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int temp = 0;
        if (row1 > 0 && col1 > 0) {
            temp += prev[row1 - 1][col2];
            temp += prev[row2][col1 - 1];
            temp -= prev[row1 - 1][col1 - 1];
        } else {
            if (row1 > 0) temp += prev[row1 - 1][col2];
            else if (col1 > 0) temp += prev[row2][col1 - 1];
        }
        return prev[row2][col2] - temp;
    }
}
