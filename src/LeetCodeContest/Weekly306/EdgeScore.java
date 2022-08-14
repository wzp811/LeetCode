package LeetCodeContest.Weekly306;

import java.util.HashMap;

public class EdgeScore {
    public int edgeScore(int[] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            int cnt = map.getOrDefault(edges[i], 0);
            cnt += i;
            if (cnt > max) {
                max = cnt;
                res = edges[i];
            } else if (cnt == max) {
                res = Math.min(res, edges[i]);
            }
            map.put(edges[i], cnt);
        }
        return res;
    }
}
