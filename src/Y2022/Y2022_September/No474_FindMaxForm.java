package Y2022.Y2022_September;

import java.util.Arrays;

public class No474_FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] cnt = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            int tmp = 0;
            for (int j = 0; j < strs[i].length(); j++) tmp += strs[i].charAt(j) - '0';
            cnt[i][0] = strs[i].length() - tmp;
            cnt[i][1] = tmp;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = m; j >= cnt[i][0]; j--) {
                for (int k = n; k >= cnt[i][1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - cnt[i][0]][k - cnt[i][1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
