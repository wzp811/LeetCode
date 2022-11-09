package Y2022.Y2022_November;

import java.util.Arrays;

public class No764_OrderOfLargestPlusSign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(matrix[i], 1);
        for (int[] mine : mines) {
            matrix[mine[0]][mine[1]] = 0;
        }
        int[][][] pre = new int[n][n][4];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // row l to r
                if (j == 0 || matrix[i][j] == 0) {
                    pre[i][j][0] = matrix[i][j];
                } else {
                    pre[i][j][0] = pre[i][j - 1][0] + 1;
                }
                // row r to l
                if (j == 0 || matrix[i][n - j - 1] == 0) {
                    pre[i][n - j - 1][2] = matrix[i][n - j - 1];
                } else {
                    pre[i][n - j - 1][2] = pre[i][n - j][2] + 1;
                }
                // col u to d
                if (i == 0 || matrix[i][j] == 0) {
                    pre[i][j][1] = matrix[i][j];
                } else {
                    pre[i][j][1] = pre[i - 1][j][1] + 1;
                }
                // col d to u
                if (i == 0 || matrix[n - i - 1][j] == 0) {
                    pre[n - i - 1][j][3] = matrix[n - i - 1][j];
                } else {
                    pre[n - i - 1][j][3] = pre[n - i][j][3] + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, Math.min(Math.min(pre[i][j][0], pre[i][j][2]), Math.min(pre[i][j][1], pre[i][j][3])));
            }
        }
        return res;
    }
}
