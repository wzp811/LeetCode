package Y2022.Y2022_September;

import java.util.Arrays;

public class No1049_LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        boolean[] dp = new boolean[sum / 2 + 1];
        int res = 0;
        dp[0] = true;
        for (int i = 0; i < stones.length; i++) {
            for (int j = sum / 2; j >= stones[i]; j--) {
                dp[j] |= dp[j - stones[i]];
                if (dp[j] && j > res) res = j;
            }
        }
        return sum - sum + res;
    }
}
