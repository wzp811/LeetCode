package QuestionList.Coding_Interviews;

import java.util.HashSet;
import java.util.Set;

public class No119_LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int res = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) continue;
            int curLen = 1;
            int cur = num + 1;
            while (set.contains(cur)) {
                cur++;
                curLen++;
            }
            res = Math.max(res, curLen);
        }
        return res;
    }
}
