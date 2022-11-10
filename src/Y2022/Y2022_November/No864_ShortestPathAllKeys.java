package Y2022.Y2022_November;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No864_ShortestPathAllKeys {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int res = Integer.MAX_VALUE;
    int keyCnt = 0;
    public int shortestPathAllKeys(String[] grid) {
        int beginX = 0, beginY = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                if (grid[i].charAt(j) == '@') {
                    beginX = i;
                    beginY = j;
                } else if (Character.isUpperCase(grid[i].charAt(j))) {
                    keyCnt++;
                }
            }
        }
        int[][] visited = new int[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) Arrays.fill(visited[i], -1);
        process(grid, new HashSet<>(), beginX, beginY, visited, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void process(String[] grid, Set<Character> keys, int x, int y, int[][] visited, int steps) {
        // System.out.println(keys);
        // System.out.println(x + " " + y);
        // for (int i = 0; i < grid.length; i++) System.out.println(Arrays.toString(visited[i]));
        // System.out.println();
        if (keys.size() == keyCnt) {
            res = Math.min(res, steps);
            return;
        }
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX >= grid.length
                    || nextY < 0 || nextY >= grid[0].length()
                    || grid[nextX].charAt(nextY) == '#'
                    || Character.isUpperCase(grid[nextX].charAt(nextY)) && !keys.contains(Character.toLowerCase(grid[nextX].charAt(nextY)))
                    || visited[nextX][nextY] == keys.size()) {
                continue;
            }
            char ch = grid[nextX].charAt(nextY);
            int tmp = visited[nextX][nextY];
            boolean flag = false;
            if (Character.isLowerCase(ch) && !keys.contains(ch)) {
                keys.add(ch);
                flag = true;
            }
            visited[nextX][nextY] = keys.size();
            process(grid, keys, nextX, nextY, visited, steps + 1);
            if (visited[nextX][nextY] != tmp) {
                visited[nextX][nextY] = tmp;
            }
            if (flag) {
                keys.remove(ch);
            }
        }
    }
}
