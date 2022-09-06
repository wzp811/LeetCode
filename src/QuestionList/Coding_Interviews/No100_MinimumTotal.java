package QuestionList.Coding_Interviews;

import java.util.Arrays;
import java.util.List;

public class No100_MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> cur = triangle.get(i);
            for (int j = cur.size() - 1; j >= 0; j--) {
                if (j > 0) dp[j] = Math.min(dp[j], dp[j - 1]) + cur.get(j);
                else dp[j] += cur.get(j);
            }
        }
        int res = dp[0];
        for (int i = 1; i < triangle.size(); i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }
}
