package QuestionList.Coding_Interviews;

import java.util.HashMap;

public class No11_FindMaxLength {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] == 0 ? -1 : 1;
        }
        int[] prev = new int[nums.length];
        prev[0] = nums[0];
        map.put(prev[0], 0);
        int ans = nums.length + 1;
        for (int i = 1; i < nums.length; i++) {
            prev[i] = prev[i - 1] + nums[i];
            if (map.containsKey(-prev[i])) {
                ans = Math.min(ans, i - map.get(-prev[i]) + 1);
            }
            if (!map.containsKey(prev[i])) {
                map.put(prev[i], i);
            }
        }
        return ans;
    }
}
