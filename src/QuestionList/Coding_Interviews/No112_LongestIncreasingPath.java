package QuestionList.Coding_Interviews;

public class No112_LongestIncreasingPath {
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] steps = new int[n][m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, process(i, j, steps, matrix));
            }
        }
        return res;
    }

    public int process(int row, int col, int[][] steps, int[][] matrix) {
        if (steps[row][col] != 0) return steps[row][col];
        steps[row][col]++;
        for (int[] d : dir) {
            int nextI = row + d[0];
            int nextJ = col + d[1];
            if (nextI >= 0 && nextI < matrix.length
                    && nextJ >= 0 && nextJ < matrix[0].length
                    && matrix[nextI][nextJ] > matrix[row][col]) {
                steps[row][col] = Math.max(steps[row][col], process(nextI, nextJ, steps, matrix) + 1);
            }
        }
        return steps[row][col];
    }
}
