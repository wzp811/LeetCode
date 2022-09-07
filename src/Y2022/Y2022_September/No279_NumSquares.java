package Y2022.Y2022_September;

import java.util.Arrays;

public class No279_NumSquares {
    public int numSquares(int n) {
        int num = 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        while (num * num <= n) {
            for (int j = num * num; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - num * num] + 1);
            }
            num++;
        }
        return dp[n];
    }
}
