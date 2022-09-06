package QuestionList.QuestOfTheDay;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No417_PacificAtlantic {
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (process(heights, i, j)) {
                    List<Integer> cur = new LinkedList<>();
                    cur.add(i);
                    cur.add(j);
                    res.add(cur);
                }
            }
        }
        return res;
    }

    public boolean process(int[][] heights, int i, int j) {
        return process(heights, i, j, true) && process(heights, i, j, false);
    }

    public boolean process(int[][] heights, int i, int j, boolean Atlantic) {
        int curI = i, curJ = j;
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        visited[i][j] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{curI, curJ});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            curI = cur[0];
            curJ = cur[1];
            for (int k = 0; k < 4; k++) {
                int tmpI = curI + dir[k][0];
                int tmpJ = curJ + dir[k][1];
                if (tmpI < 0 || tmpJ < 0) {
                    if (Atlantic) return true;
                    continue;
                }
                if (tmpI == heights.length || tmpJ == heights[0].length) {
                    if (!Atlantic) return true;
                    continue;
                }
                if (!visited[tmpI][tmpJ] && heights[tmpI][tmpJ] <= heights[curI][curJ]) {
                    queue.add(new int[]{tmpI, tmpJ});
                    visited[tmpI][tmpJ] = true;
                }
            }
        }
        return false;
    }

    public List<List<Integer>> pacificAtlantic1(int[][] heights) {
        List<List<Integer>> res = new LinkedList<>();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            queue.add(new int[]{i, 0});
            pacific[i][0] = true;
        }
        for (int i = 0; i < heights[0].length; i++) {
            queue.add(new int[]{0, i});
            pacific[0][i] = true;
        }
        queue.remove(0);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curI = cur[0], curJ = cur[1];
            for (int i = 0; i < 4; i++) {
                int tmpI = curI + dir[i][0], tmpJ = curJ + dir[i][1];
                if (tmpI < 0 || tmpI == heights.length || tmpJ < 0 || tmpJ == heights[0].length) continue;
                if (!pacific[tmpI][tmpJ] && heights[tmpI][tmpJ] >= heights[curI][curJ]) {
                    queue.add(new int[]{tmpI, tmpJ});
                    pacific[tmpI][tmpJ] = true;

                }
            }
        }
        for (int i = 0; i < heights.length; i++) {
            queue.add(new int[]{i, heights[0].length - 1});
            atlantic[i][heights[0].length - 1] = true;
        }
        for (int i = 0; i < heights[0].length; i++) {
            queue.add(new int[]{heights.length - 1, i});
            atlantic[heights.length - 1][i] = true;
        }
        queue.remove(0);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curI = cur[0], curJ = cur[1];
            for (int i = 0; i < 4; i++) {
                int tmpI = curI + dir[i][0], tmpJ = curJ + dir[i][1];
                if (tmpI < 0 || tmpI == heights.length || tmpJ < 0 || tmpJ == heights[0].length) continue;
                if (!atlantic[tmpI][tmpJ] && heights[tmpI][tmpJ] >= heights[curI][curJ]) {
                    queue.add(new int[]{tmpI, tmpJ});
                    atlantic[tmpI][tmpJ] = true;

                }
            }
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cur = new LinkedList<>();
                    cur.add(i);
                    cur.add(j);
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
