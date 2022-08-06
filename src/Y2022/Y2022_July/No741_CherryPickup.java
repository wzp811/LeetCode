package Y2022.Y2022_July;

public class No741_CherryPickup {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[2 * n + 1][n + 1][n + 1];
        for (int i = 0;i <= 2 * n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        dp[2][1][1] = grid[0][0];
        for (int i = 3; i <= 2 * n; i++) {
            for (int i1 = 1; i1 <= n; i1++) {
                for (int i2 = 1; i2 <= n; i2++) {
                    int j1 = i - i1, j2 = i - i2;
                    if (j1 <= 0 || j1 > n || j2 <= 0 || j2 > n) continue;
                    if (grid[i1 - 1][j1 - 1] == -1 || grid[i2 - 1][j2 - 1] == -1) continue;
                    int t1 = dp[i - 1][i1][i2], t2 = dp[i - 1][i1 - 1][i2], t3 = dp[i - 1][i1][i2 - 1], t4 = dp[i - 1][i1 - 1][i2 - 1];
                    int t = Math.max(Math.max(t1, t2), Math.max(t3, t4)) + grid[i1 - 1][j1 - 1];
                    if (i1 != i2) t += grid[i2 - 1][j2 - 1];
                    dp[i][i1][i2] = t;
                }
            }
        }
        return dp[2 * n][n][n] < 0 ? 0 : dp[2 * n][n][n];
    }


}
