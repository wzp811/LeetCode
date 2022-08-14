package LeetCodeContest.Weekly306;

import java.util.ArrayList;
import java.util.List;

public class CountSpecialNumbers {
    int[][] f = new int[10][10];
    public int countSpecialNumbers(int n) {
        for (int i = 1; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                int cur = 1;
                for (int k = i; k <= j; k++) cur *= k;
                f[i][j] = cur;
            }
        }
        return dp(n);
    }
    int dp(int x) {
        int t = x;
        List<Integer> list = new ArrayList<>();
        while (t != 0) {
            list.add(t % 10);
            t /= 10;
        }
        int n = list.size();
        if (n <= 1) return x;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            int p = 1;
            int s = 0;
            int cur = list.get(i);
            int cnt = 0;
            for (int j = cur - 1; j >= 0; j--) {
                if (i == n - 1 && j == 0) continue;
                if (((s >> j) & 1) == 0) cnt++;
            }
            int a = 10 - p, b = a - (n - p) + 1;
            res += b <= a ? cnt * f[b][a] : cnt;
            if (((s >> cur) & 1) == 1) break;
            s |= (1 << cur);
            if (i == 0) res ++;
            p++;
        }
        res += 10;
        for (int i = 2; i < n; i++) {
            int last = 9;
            int cur = last * (10 - i + 1);
            res += cur;
            last = cur;
        }
        return res;
    }
}
