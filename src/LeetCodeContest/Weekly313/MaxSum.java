package LeetCodeContest.Weekly313;

public class MaxSum {
    public int maxSum(int[][] grid) {
        long[][] pre = new long[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                pre[i][j] = grid[i][j];
                if (j > 0) pre[i][j] += pre[i][j - 1];
            }
        }
        long res = 0;
        for (int i = 2; i < grid.length; i++) {
            for (int j = 2; j < grid[0].length; j++) {
                long cur = pre[i - 2][j] + pre[i][j];
                if (j > 2) cur -= pre[i - 2][j - 3] + pre[i][j - 3];
                cur += grid[i - 1][j - 1];
                res = Math.max(res, cur);
            }
        }
        return (int) res;
    }
}
