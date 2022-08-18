package Y2022.Y2022_August;

import java.util.HashMap;

public class No1224_MaxEqualFreq {
    public int maxEqualFreq(int[] nums) {
        int res = 1;
        int max = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        HashMap<Integer, Integer> sum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curCnt = cnt.getOrDefault(nums[i], 0);
            cnt.put(nums[i], curCnt + 1);
            if (!sum.containsKey(curCnt) || curCnt == 0) {
                sum.put(1, sum.getOrDefault(1, 0) + 1);
            } else {
                sum.put(curCnt, sum.get(curCnt) - 1);
                if (sum.get(curCnt) == 0) sum.remove(curCnt);
                sum.put(curCnt + 1, sum.getOrDefault(curCnt + 1, 0) + 1);
            }
            max = Math.max(max, curCnt + 1);
            if (sum.size() == 2 && (sum.get(max) * max == i || sum.containsKey(max - 1) && sum.get(max) == 1)
                    || max == 1 || cnt.size() == 1)
                res = i;
        }
        return res + 1;
    }
}
