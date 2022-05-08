package Coding_Interviews;

import java.util.LinkedList;
import java.util.Queue;

public class No105_MaxAreaOfIsland {
    int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int tmp = 0;
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        tmp++;
                        for (int[] d : dir) {
                            int curI = cur[0] + d[0];
                            int curJ = cur[1] + d[1];
                            if (curI >= grid.length || curI < 0 || curJ >= grid[0].length || curJ < 0) continue;
                            if (!visited[curI][curJ] && grid[curI][curJ] == 1) {
                                visited[curI][curJ] = true;
                                queue.add(new int[] {curI, curJ});
                            }
                        }
                    }
                    res = Math.max(res, tmp);
                }
            }
        }
        return res;
    }

}
