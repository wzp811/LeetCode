package Coding_Interviews;

import java.util.Arrays;

public class No96_IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) Arrays.fill(dp[i], false);
        dp[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i > 0) dp[i][j] |= (s1.charAt(i - 1) == s3.charAt(i + j - 2) && dp[i - 1][j]);
                if (j > 0) dp[i][j] |= (s2.charAt(j - 1) == s3.charAt(i + j - 2) && dp[i][j - 1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
