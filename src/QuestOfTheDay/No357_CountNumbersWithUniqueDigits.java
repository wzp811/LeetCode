package QuestOfTheDay;

public class No357_CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int cnt = 0;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] * (10 - i);
            dp[i][1] = dp[i - 1][0] * (i - 1);
        }
        for (int i = 0; i <= n; i++) {
            cnt += dp[i][0];
            cnt += dp[i][1];
        }
        return cnt;
    }
}
