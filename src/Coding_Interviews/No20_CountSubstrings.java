package Coding_Interviews;

public class No20_CountSubstrings {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) dp[i][j] = true;
                else if (i + 1 < s.length() && j - 1 >= 0 && (dp[i + 1][j - 1] || j == i + 1) && s.charAt(j) == s.charAt(i)) dp[i][j] = true;
                if (dp[i][j]) cnt++;
            }
        }
        return cnt;
    }
}
