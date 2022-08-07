package LeetCodeContest.Biweekly84;

import java.util.HashMap;
import java.util.Map;

public class CountBadPairs {
    public long countBadPairs(int[] nums) {
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = i - nums[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tmp.length; i++) {
            int cnt = map.getOrDefault(tmp[i], 0);
            map.put(tmp[i], cnt + 1);
        }
        long res = (long) nums.length * (nums.length - 1) / 2;
        for (int cur : map.keySet()) {
            int num = map.get(cur);
            res -= (long) num * (num - 1) / 2;
        }
        return res;
    }
}
