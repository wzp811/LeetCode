package LeetCodeContest.Biweekly86;

import java.util.HashSet;

public class MaximumRows {
    public int maximumRows(int[][] mat, int cols) {
        int m = mat.length;
        int n = mat[0].length;
        int[] cnt0 = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt0[i] += 1 - mat[j][i];
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n - cols; i++) {
            int maxCol = 0;
            int inSetCount = 0;
            for (int j = 0; j < n; j++) {
                if (cnt0[j] >= cnt0[maxCol]) {
                    int tmp = 0;
                    for (int k = 0; k < m; k++) {
                        if (mat[k][j] == 1 && set.contains(k)) tmp++;
                    }
                    if (cnt0[j] > cnt0[maxCol] || j == 0 && cnt0[j] > 0) {
                        inSetCount = tmp;
                    } else if (cnt0[j] == cnt0[maxCol] && tmp > inSetCount) {
                        inSetCount = tmp;
                        maxCol = j;
                    }
                }
            }
            for (int j = 0; j < m; j++) {
                if (mat[j][maxCol] == 1) set.add(j);
            }
            cnt0[maxCol] = 0;
        }
        return m - set.size();
    }
}
