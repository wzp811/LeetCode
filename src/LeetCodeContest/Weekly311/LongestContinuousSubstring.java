package LeetCodeContest.Weekly311;

public class LongestContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        int res = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) + 1) {
                cur++;
            } else {
                cur = 1;
            }
            res = Math.max(cur, res);
        }
        return res;
    }
}
