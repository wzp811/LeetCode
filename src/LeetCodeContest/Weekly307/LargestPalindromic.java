package LeetCodeContest.Weekly307;

public class LargestPalindromic {
    public String largestPalindromic(String num) {
        int[] cnt = new int[10];
        for (int i = 0; i < num.length(); i++) {
            cnt[num.charAt(i) - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        int cur = 9;
        int mid = -1;
        while (cur >= 0) {
            if (!(sb.length() == 0 && cur == 0)) {
                int c = cnt[cur] / 2;
                cnt[cur] %= 2;
                while (c-- > 0) sb.append(cur);
            }
            if ((cnt[cur] == 1 || cur == 0 && cnt[cur] > 0) && mid == -1) mid = cur;
            cur--;
        }
        if (sb.length() == 0) return sb.append(Math.max(mid, 0)).toString();
        StringBuilder tmp = new StringBuilder(sb);
        return sb.append(mid).append(tmp.reverse()).toString();
    }
}
