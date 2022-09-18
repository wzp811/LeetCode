package LeetCodeContest.Biweekly87;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumMoney {
    public long minimumMoney(int[][] transactions) {
        long res = 0;
        Arrays.sort(transactions, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        int cur = 0;
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i][0] > cur) {
                res += transactions[i][0] - cur;
                cur = transactions[i][1];
            } else {
                cur -= transactions[i][0];
                cur += transactions[i][1];
            }
        }
        return res;
    }
}
