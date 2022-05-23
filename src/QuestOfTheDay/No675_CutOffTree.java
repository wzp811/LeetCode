package QuestOfTheDay;

import java.util.*;

public class No675_CutOffTree {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int cutOffTree(List<List<Integer>> forest) {
        int n = forest.size();
        int m = forest.get(0).size();
        List<int[]> trees = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{forest.get(i).get(j), i, j});
                }
            }
        }
        trees.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int res = 0;
        int dis = bfs(forest, new int []{-1, 0, 0}, trees.get(0));
        if (dis == Integer.MAX_VALUE) return -1;
        res += dis;
        for (int i = 0; i < trees.size() - 1; i++) {
            int[] curPoint = trees.get(i);
            int[] nextPoint = trees.get(i + 1);
            dis = bfs(forest, curPoint, nextPoint);
            if (dis == Integer.MAX_VALUE) return -1;
            res += bfs(forest, curPoint, nextPoint);
        }
        return res;
    }

    public int bfs(List<List<Integer>> forest, int[] curPoint, int[] nextPoint) {
        if (curPoint[1] == nextPoint[1] && curPoint[2] == nextPoint[2]) return 0;
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[] {curPoint[1], curPoint[2]});
        int steps = 0;
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        visited[curPoint[1]][curPoint[2]] = true;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.pollFirst();
                for (int[] dir : dirs) {
                    int nextI = cur[0] + dir[0];
                    int nextJ = cur[1] + dir[1];
                    if (nextI < 0 || nextI >= forest.size() || nextJ < 0 || nextJ >= forest.get(0).size() || visited[nextI][nextJ] || forest.get(nextI).get(nextJ) == 0) continue;
                    if (nextI == nextPoint[1] && nextJ == nextPoint[2]) return steps;
                    visited[nextI][nextJ] = true;
                    queue.addLast(new int[]{nextI, nextJ});
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
