package Y2022.Y2022_November;

public class No1668_MaxRepeating {
    public int maxRepeating(String sequence, String word) {
        int[] dp = new int[sequence.length() + 1];
        int res = 0;
        for (int i = word.length(); i < sequence.length(); i++) {
            String sub = sequence.substring(i - word.length(), i);
            if (sub.equals(word)) dp[i] = dp[i - word.length()] + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
