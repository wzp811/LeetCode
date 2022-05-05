package Coding_Interviews;

public class No92_MinFlipsMonoIncr {
    public int minFlipsMonoIncr(String s) {
        int[][] dp = new int[s.length()][2];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = 1 - dp[0][0];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0]) + 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        return Math.min(dp[s.length() - 1][0], dp[s.length() - 1][1]);
    }
}
