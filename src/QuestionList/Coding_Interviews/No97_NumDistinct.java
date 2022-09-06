package QuestionList.Coding_Interviews;

public class No97_NumDistinct {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (i > 0 && s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[j][i] = dp[j - 1][i - 1] + dp[j - 1][i];
                } else {
                    dp[j][i] = dp[j - 1][i];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
