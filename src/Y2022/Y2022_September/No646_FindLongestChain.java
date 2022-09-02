package Y2022.Y2022_September;

import java.util.Arrays;
import java.util.Comparator;

public class No646_FindLongestChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] dp = new int[pairs.length];
        int res = 0;
        for (int i = 0; i < pairs.length; i++) {
            int index = i - 1;
            while (index >= 0) {
                if (pairs[i][0] > pairs[index][1]) {
                    dp[i] = dp[index] + 1;
                }
                index--;
            }
            if (index == -1) dp[i] = 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
