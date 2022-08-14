package LeetCodeContest.Weekly306;

public class LargestLocal {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        int[][] dir = new int[][] {{-1, -1}, {0, -1}, {1, -1},
                {-1, 0}, {0, 0}, {1, 0},
                {-1, 1}, {0, 1}, {1, 1}};
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int max = 0;
                for (int k = 0; k < 9; k++) {
                    max = Math.max(max, grid[i + dir[k][0]][j + dir[k][1]]);
                }
                res[i - 1][j - 1] = max;
            }
        }
        return res;
    }
}
