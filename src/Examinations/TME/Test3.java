package Examinations.TME;

import java.util.Arrays;

public class Test3 {
    public int numsOfGoodMatrix(int n, int m, int x) {
        // write code here
        long cnt0 = x / 2;
        long cnt1 = x / 2 + x % 2;
        long cntMatrix = (n - 1) * (m - 1);
        long mod = (long) 1e9 + 7;
        long[][][] dp = new long[n + 1][m + 1][8];
        Arrays.fill(dp[0][0], 1);
        long cnt00 = cnt0 * cnt0 % mod;
        long cnt11 = cnt1 * cnt1 % mod;
        long cnt01 = cnt0 * cnt1 % mod;
        for (int i = 1; i <= n; i++) {
            dp[i][0][0] += (dp[i - 1][0][0] * cnt00 % mod + dp[i - 1][0][3] * cnt00 % mod) % mod;
            dp[i][0][1] += (dp[i - 1][0][1] * cnt01 % mod + dp[i - 1][0][5] * cnt01 % mod) % mod;
            dp[i][0][2] += (dp[i - 1][0][2] * cnt01 % mod + dp[i - 1][0][6] * cnt01 % mod) % mod;
            dp[i][0][3] += (dp[i - 1][0][4] * cnt00 % mod + dp[i - 1][0][7] * cnt00 % mod) % mod;
            dp[i][0][4] += (dp[i - 1][0][0] * cnt11 % mod + dp[i - 1][0][3] * cnt11 % mod) % mod;
            dp[i][0][5] += (dp[i - 1][0][2] * cnt01 % mod + dp[i - 1][0][6] * cnt01 % mod) % mod;
            dp[i][0][6] += (dp[i - 1][0][1] * cnt01 % mod + dp[i - 1][0][5] * cnt01 % mod) % mod;
            dp[i][0][7] += (dp[i - 1][0][7] * cnt11 % mod + dp[i - 1][0][4] * cnt11 % mod) % mod;
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i][0] += (dp[0][i - 1][0] * cnt00 % mod + dp[0][i - 1][2] * cnt00 % mod) % mod;
            dp[0][i][1] += (dp[0][i - 1][2] * cnt00 % mod + dp[0][i - 1][7] * cnt00 % mod) % mod;
            dp[0][i][2] += (dp[0][i - 1][0] * cnt11 % mod + dp[0][i - 1][1] * cnt11 % mod) % mod;
            dp[0][i][3] += (dp[0][i - 1][3] * cnt01 % mod + dp[0][i - 1][5] * cnt01 % mod) % mod;
            dp[0][i][4] += (dp[0][i - 1][4] * cnt01 % mod + dp[0][i - 1][6] * cnt01 % mod) % mod;
            dp[0][i][5] += (dp[0][i - 1][4] * cnt01 % mod + dp[0][i - 1][6] * cnt01 % mod) % mod;
            dp[0][i][6] += (dp[0][i - 1][3] * cnt01 % mod + dp[0][i - 1][5] * cnt01 % mod) % mod;
            dp[0][i][7] += (dp[0][i - 1][2] * cnt11 % mod + dp[0][i - 1][7] * cnt11 % mod) % mod;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                dp[i][j][0] = (dp[i - 1][j][0] * dp[i][j - 1][0] + dp[i - 1][j][1] * dp[i][j - 1][0] + dp[i - 1][j][3] * dp[i][j - 1][0]) % mod * cnt0 % mod;
                dp[i][j][1] = (dp[i - 1][j][2] * dp[i][j - 1][1] + dp[i - 1][j][7] * dp[i][j - 1][1] + dp[i - 1][j][5] * dp[i][j - 1][2] + dp[i - 1][j][5] * dp[i][j - 1][7]) % mod * cnt0 % mod;
                dp[i][j][2] = (dp[i - 1][j][2] * dp[i][j - 1][0] + dp[i - 1][j][2] * dp[i][j - 1][1] + dp[i - 1][j][6] * dp[i][j - 1][0] + dp[i - 1][j][6] * dp[i][j - 1][1]) % mod * cnt1 % mod;
                dp[i][j][3] = (dp[i - 1][j][4] * dp[i][j - 1][3] + dp[i - 1][j][4] * dp[i][j - 1][5] + dp[i - 1][j][7] * dp[i][j - 1][3] + dp[i - 1][j][7] * dp[i][j - 1][5]) % mod * cnt0 % mod;
                dp[i][j][4] = (dp[i - 1][j][0] * dp[i][j - 1][4] + dp[i - 1][j][0] * dp[i][j - 1][6] + dp[i - 1][j][3] * dp[i][j - 1][4] + dp[i - 1][j][3] * dp[i][j - 1][6]) % mod * cnt1 % mod;
                dp[i][j][5] = (dp[i - 1][j][2] * dp[i][j - 1][4] + dp[i - 1][j][2] * dp[i][j - 1][6] + dp[i - 1][j][6] * dp[i][j - 1][4] + dp[i - 1][j][6] * dp[i][j - 1][6]) % mod * cnt0 % mod;
                dp[i][j][6] = (dp[i - 1][j][1] * dp[i][j - 1][3] + dp[i - 1][j][1] * dp[i][j - 1][5] + dp[i - 1][j][5] * dp[i][j - 1][4] + dp[i - 1][j][5] * dp[i][j - 1][5]) % mod * cnt1 % mod;
                dp[i][j][7] = (dp[i - 1][j][7] * dp[i][j - 1][7] + dp[i - 1][j][4] * dp[i][j - 1][7] + dp[i - 1][j][7] * dp[i][j - 1][2]) % mod * cnt1 % mod;
            }
        }
        long res = 0;
        for (int i = 0; i < 8; i++){
            res += dp[n][m][i] % mod;
        }
        return (int) (res % mod);
    }
}
