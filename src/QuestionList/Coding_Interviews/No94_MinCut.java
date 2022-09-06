package QuestionList.Coding_Interviews;

import java.util.Arrays;

public class No94_MinCut {
    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (boolean[] tmp : dp) Arrays.fill(tmp, true);
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }
        int[] res = new int[s.length()];
        Arrays.fill(res, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            if (dp[0][i]) res[i] = 0;
            for (int j = 0; j < i; j++) {
                if (dp[j][i]) res[i] = Math.min(res[i], res[j] + 1);
            }
        }
        return res[s.length() - 1];
    }
}
