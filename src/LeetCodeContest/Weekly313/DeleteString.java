package LeetCodeContest.Weekly313;

public class DeleteString {
    int res = 0;
    public int deleteString(String s) {
        int[][] next = new int[s.length()][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= i + (s.length() - i) / 2; j++) {
                if (s.charAt(i) != s.charAt(j)) continue;
                boolean tmp = true;
                for (int k = 0; k < j - i; k++) {
                    if (s.charAt(i + k) != s.charAt(j + k)) {
                        tmp = false;
                        break;
                    }
                }
                if (!tmp) continue;
                next[i][++next[i][0]] = j;
            }
        }
        dfs(s, next, 0, 0);
        return res;
    }
    public void dfs(String s, int[][] next, int index, int cnt) {
        for (int i = 0; i < next[index][0]; i++) {
            dfs(s, next, next[index][i + 1], cnt + 1);
        }
        res = Math.max(res, cnt);
    }
}
