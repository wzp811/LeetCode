package LeetCodeContest.Weekly310;

import java.util.Arrays;

public class PartitionString {
    public int partitionString(String s) {
        int[] cnt = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            cnt[index]++;
            if (cnt[index] > 1) {
                Arrays.fill(cnt, 0);
                cnt[index] = 1;
                res++;
            }
        }
        return res + 1;
    }
}
