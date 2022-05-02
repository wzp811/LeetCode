package Coding_Interviews;

import java.util.LinkedList;
import java.util.List;

public class No86_Partition {
    public String[][] partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) dp[i][i] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        List<List<String>> res = new LinkedList<>();
        List<String> cur = new LinkedList<>();
        process(res, cur, s.toCharArray(), 0, dp);
        String[][] chs = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            chs[res.size() - 1 - i] = new String[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                chs[res.size() - 1 - i][j] = res.get(i).get(j);
            }
        }
        return chs;
    }

    public void process(List<List<String>> res, List<String> cur, char[] str, int begin, boolean[][] dp) {
        System.out.println(res);
        System.out.println(cur);
        System.out.println(begin);
        System.out.println();
        for (int i = begin; i < str.length; i++) {

            int size = cur.size();
            if (!dp[begin][i]) continue;
            cur.add(new String(str, begin, i - begin + 1));
            process(res, cur, str, i + 1, dp);
            cur.remove(size);
        }

    }
}
