package QuestOfTheDay;

import java.util.ArrayList;
import java.util.List;

public class No442_FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int abs = nums[i] < 0 ? -nums[i] : nums[i];
            if (nums[abs - 1] < 0) res.add(abs);
            nums[abs - 1] = -nums[abs - 1];
        }
        return res;
    }
}
