package Coding_Interviews;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No86_Partition {
    public String[][] partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) Arrays.fill(dp[i], true);
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }
        List<List<String>> res = new LinkedList<>();
        List<String> cur = new LinkedList<>();
        process(res, cur, s, 0, dp);
        String[][] ret = new String[res.size()][];
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < res.get(i).size(); j++) ret[i][j] = res.get(i).get(j);
        }
        return ret;
    }

    public void process(List<List<String>> res, List<String> cur, String s, int index, boolean[][] dp) {
        if (index == s.length()) {
            res.add(new LinkedList<>(cur));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {
                cur.add(s.substring(index, i - index + 1));
                process(res, cur, s, i + 1, dp);
                cur.remove(cur.size() - 1);
            }
        }
        return;
    }

}
