package Coding_Interviews;

import java.util.HashMap;

public class No93_LenLongestFibSubseq {
    public int lenLongestFibSubseq(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
            for (int j = i - 1; j >= 0; j--) {
                if (map.containsKey(arr[i] - arr[j])) {
                    int index = map.get(arr[i] - arr[j]);
                    dp[i][j] = dp[j][index] + 1;
                } else {
                    dp[i][j] = 2;
                }
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }
}
