package Y2022_July;

import java.util.ArrayList;
import java.util.List;

public class No1260_ShiftGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int y = k / n % m;
        int x = k % n;
        int[][] tmp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newI = (i + y) % m;
                int newJ = (j + x) % n;
                if (j < x) {
                    newI = (newI + 1) % m;
                }
                tmp[newI][newJ] = grid[i][j];
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                cur.add(tmp[i][j]);
            }
            res.add(cur);
        }
        return res;
    }
}
