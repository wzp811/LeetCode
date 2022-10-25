package Y2022.Y2022_October;

import java.util.ArrayDeque;
import java.util.Deque;

public class No934_ShortestBridge {
    public int shortestBridge(int[][] grid) {
        boolean hasFound = false;
        int[] position = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                hasFound = true;
                position[0] = i;
                position[1] = j;
                grid[i][j] = -1;
                break;
            }
            if (hasFound) break;
        }
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(position);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.pollFirst();
                for (int[] dir : dirs) {
                    int nextI = cur[0] + dir[0];
                    int nextJ = cur[1] + dir[1];
                    if (nextI < 0 || nextI >= grid.length
                            || nextJ < 0 || nextJ >= grid[0].length
                            || grid[nextI][nextJ] != 1)
                        continue;
                    grid[nextI][nextJ] = -1;
                    queue.addLast(new int[]{nextI, nextJ});
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != -1) continue;
                if ((i == 0 || grid[i - 1][j] == -1) && (j == 0 || grid[i][j - 1] == -1)
                        && (i == grid.length - 1 || grid[i + 1][j] == -1) && (j == grid[0].length - 1 || grid[i][j + 1] == -1))
                    continue;
                queue.clear();
                queue.add(new int[]{i, j});
                int curLen = 0;
                hasFound = false;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    curLen++;
                    for (int k = 0; k < size; k++) {
                        int[] cur = queue.pollFirst();
                        for (int[] dir : dirs) {
                            int nextI = cur[0] + dir[0];
                            int nextJ = cur[1] + dir[1];
                            if (nextI < 0 || nextI >= grid.length
                                    || nextJ < 0 || nextJ >= grid[0].length
                                    || grid[nextI][nextJ] == -1)
                                continue;
                            queue.addLast(new int[]{nextI, nextJ});
                            if (grid[nextI][nextJ] == 1) {
                                hasFound = true;
                            }
                        }
                        if (hasFound) break;
                    }
                    if (hasFound) break;
                }
                if (hasFound) res = Math.min(res, curLen);
            }
        }
        return res;
    }
}
