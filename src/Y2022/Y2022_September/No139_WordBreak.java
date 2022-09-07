package Y2022.Y2022_September;

import java.util.Arrays;
import java.util.List;

public class No139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 0; j <= s.length(); j++) {
            for (int i = 0; i < wordDict.size(); i++) {
                if (j >= wordDict.get(i).length() && s.substring(j - wordDict.get(i).length(), j).equals(wordDict.get(i))) {
                    dp[j] |= dp[j - wordDict.get(i).length()];
                }
            }
        }
        return dp[s.length()];
    }
}
