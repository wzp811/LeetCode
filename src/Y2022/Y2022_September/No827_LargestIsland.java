package Y2022.Y2022_September;

import java.util.*;

public class No827_LargestIsland {
    public int largestIsland(int[][] grid) {
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] indexs = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) Arrays.fill(indexs[i], -1);
        int index = 0;
        List<Integer> areas = new ArrayList<>();
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                Deque<int[]> queue = new ArrayDeque<>();
                List<int[]> list = new ArrayList<>();
                queue.addLast(new int[]{i, j});
                visited[i][j] = true;
                list.add(new int[]{i, j});
                int area = 0;
                while (!queue.isEmpty()) {
                    int[] cur = queue.pollFirst();
                    area++;
                    for (int[] dir : dirs) {
                        int nextI = cur[0] + dir[0];
                        int nextJ = cur[1] + dir[1];
                        if (nextI < 0 || nextI >= grid.length || nextJ < 0 || nextJ >= grid[0].length || visited[nextI][nextJ] || grid[nextI][nextJ] == 0)
                            continue;
                        int[] next = new int[]{nextI, nextJ};
                        queue.addLast(next);
                        visited[next[0]][next[1]] = true;
                        list.add(next);
                    }
                }
                areas.add(area);
                maxArea = Math.max(maxArea, area);
                for (int[] position : list) {
                    indexs[position[0]][position[1]] = index;
                }
                index++;
            }
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) continue;
                int cur = 0;
                Set<Integer> set = new HashSet<>();
                for (int[] dir : dirs) {
                    int nextI = i + dir[0];
                    int nextJ = j + dir[1];
                    if (nextI < 0 || nextI >= grid.length || nextJ < 0 || nextJ >= grid[0].length || grid[nextI][nextJ] == 0)
                        continue;
                    index = indexs[nextI][nextJ];
                    if (set.contains(index)) continue;
                    set.add(index);
                    cur += areas.get(index);
                }
                res = Math.max(res, cur);
            }
        }
        return Math.max(res + 1, maxArea);
    }

    public static class Example extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("run");
        }
    }

    public static List<Long> func(int n) {
        List<Long> res = new ArrayList<>();
        long next = 10;
        int ntmp = 1;
        long cur = 1;
        while (ntmp <= n) {
            res.add(cur++);
            if (cur == next) {
                next *= 10;
                ntmp++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(new StringBuilder(), stack, 1);
    }

    public static void dfs(StringBuilder res, Deque<Integer> stack, int cur) {
//        System.out.println(res.toString());
        if (cur == 7 && stack.isEmpty()) System.out.println(res.toString());
        while (!stack.isEmpty()) {
            res.append(String.valueOf(-stack.pollLast()));
            dfs(res, stack, cur);
        }
        for (; cur <= 6; cur++) {
            stack.addLast(cur);
            res.append(cur);
            dfs(res, stack, cur + 1);
        }
    }
}

