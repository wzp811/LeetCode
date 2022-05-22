package QuestOfTheDay;

public class No464_CanIWin {
    int n, t;
    int[] dp = new int[1 << 20];
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        n = maxChoosableInteger;
        t = desiredTotal;
        if (n * (n + 1) / 2 < t) return false;
        if (t == 0) return true;
        return process(0, 0) == 1;
    }

    public int process(int state, int sum) {
        if (dp[state] != 0) return dp[state];
        for (int i = 0; i < n; i++) {
            if (((state >> i) & 1) == 1) continue;
            if (sum + i + 1 >= t)  {
                dp[state] = 1;
                return 1;
            }
            if (process(state | (1 << i), sum + i + 1) == -1) {
                dp[state] = 1;
                return 1;
            }
        }
        dp[state] = -1;
        return -1;
    }
}
