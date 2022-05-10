package Coding_Interviews;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No107_UpdateMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(res[i], -1);
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) queue.add(new int[]{i, j});
            }
        }
        int distance = 0;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int curI = 0, curJ = 0;
                for (int[] d : dir) {
                    curI = cur[0] + d[0];
                    curJ = cur[1] + d[1];
                    if (curI < 0 || curI >= mat.length || curJ < 0 || curJ >= mat[0].length) continue;
                    if (res[curI][curJ] != -1) continue;
                    queue.add(new int[]{curI, curJ});
                    if (mat[curI][curJ] == 0) {
                        res[curI][curJ] = 0;
                    } else {
                        res[curI][curJ] = distance;
                    }
                }
                if (mat[cur[0]][cur[1]] == 0) res[cur[0]][cur[1]] = 0;
            }
        }
        return res;
    }
}
