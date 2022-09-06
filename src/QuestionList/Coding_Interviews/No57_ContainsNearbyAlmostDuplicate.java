package QuestionList.Coding_Interviews;

import java.util.TreeSet;

public class No57_ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        int i = 0;
        while (i < nums.length) {
            if (i >= k) set.remove((long)nums[i - k]);
            Long prev = set.floor((long)nums[i]);
            Long next = set.ceiling((long)nums[i]);
            if (prev != null && Math.abs((long)prev - nums[i]) <= t || next != null && Math.abs((long)next - nums[i]) <= t) return true;
            set.add((long)nums[i]);
            i++;
        }
        return false;
    }
}
