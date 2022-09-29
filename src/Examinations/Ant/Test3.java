package Examinations.Ant;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        input.nextLine();
        int[][] grass = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grass[i][j] = input.nextInt();
            }
            input.nextLine();
        }
        int q = input.nextInt();
        input.nextLine();
        List<int[]> list = new ArrayList<>();
        while (q-- > 0) {
            int[] tmp = new int[4];
            for (int i = 0; i < 4; i++) tmp[i] = input.nextInt();
            list.add(tmp);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int current = 1;
        int[][] dirs = new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, -1}, {0, -2}, {1, 0}, {2, 0}, {-1, 0}, {-2, 0}};
        int res = 0;
        for (int[] l : list) {
            int grow = 0;
            if (l[0] != current) grow = l[0] - current;
            for (int[] dir : dirs) {
                int nextI = l[1] + dir[0];
                int nextJ = l[2] + dir[1];
                if (nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= m) continue;
                res += Math.min(grass[nextI][nextJ] + grow, l[2]);
                grass[nextI][nextJ] = Math.max(0, grass[nextI][nextJ] + grow - l[2]);
            }
        }
        System.out.println(res);
    }
}
