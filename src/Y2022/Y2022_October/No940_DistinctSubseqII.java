package Y2022.Y2022_October;

public class No940_DistinctSubseqII {
    public int distinctSubseqII(String s) {
        int mod = (int) 1e9 + 7;
        boolean[] used = new boolean[26];
        long[] dp = new long[s.length()];
        dp[0] = 1;
        used[s.charAt(0)] = true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] += dp[j];
                if (s.charAt(i) == s.charAt(j)) break;
            }
            if (!used[s.charAt(i) - 'a']) {
                used[s.charAt(i) - 'a'] = true;
                dp[i]++;
            }
            dp[i] %= mod;
        }
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += dp[i];
            res %= mod;
        }
        return (int) res;
    }
}
