package Examinations.YongYou;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = 0;
        List<String> list = new ArrayList<>();
        while (input.hasNext()) {
            String s = input.nextLine();
            list.add(s);
            m++;
        }
        int n = list.get(0).split(",").length;
        boolean[][] matrix = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            String[] k = list.get(i).split(",");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = k[j].equals("1");
            }
        }
        System.out.println(getRes(matrix));
    }

    public static int getRes(boolean[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!matrix[i][j] || visited[i][j]) continue;
                int row = i, col = j;
                int cur = 0;
                Deque<int[]> queue = new ArrayDeque<>();
                queue.addLast(new int[]{row, col});
                visited[row][col] = true;
                while (!queue.isEmpty()) {
                    int[] loc = queue.pollFirst();
                    cur++;
                    for (int[] dir : dirs) {
                        int nextI = loc[0] + dir[0];
                        int nextJ = loc[1] + dir[1];
                        if (nextI < 0 || nextI >= matrix.length || nextJ < 0 || nextJ >= matrix[0].length || !matrix[nextI][nextJ] || visited[nextI][nextJ])
                            continue;
                        visited[nextI][nextJ] = true;
                        queue.addLast(new int[]{nextI, nextJ});
                    }
                }
                res = Math.max(res, cur);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
        return res;
    }
}
