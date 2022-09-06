package QuestionList.Coding_Interviews;

import java.util.HashMap;

public class No10_SubarraySum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        int[] prev = new int[nums.length];
        prev[0] = nums[0];
        map.put(prev[0], 1);
        if (prev[0] == k) cnt++;
        for (int i = 1; i < nums.length; i++) {
            prev[i] = prev[i - 1] + nums[i];
            if (prev[i] == k) cnt++;
            if (map.containsKey(prev[i] - k)) cnt += map.get(prev[i] - k);
            map.put(prev[i], map.getOrDefault(prev[i], 0) + 1);
        }
        return cnt;
    }
}
