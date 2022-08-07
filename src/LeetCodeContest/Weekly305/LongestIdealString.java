package LeetCodeContest.Weekly305;

import java.util.Arrays;

public class LongestIdealString {
    public int longestIdealString(String s, int k) {
        int res = 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            for (int j = Math.max(0, index - k); j < Math.min(26, index + k); j++) {
                dp[i] = Math.max(dp[i], last[j] + 1);
            }
            last[index] = dp[i];
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
