package QuestionList.Coding_Interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No7_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int last = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (nums[i] == last) continue;
            last = nums[i];
            int p1 = i + 1, p2 = nums.length - 1;
            while(p1 < p2) {
                if (nums[p1] + nums[p2] == -nums[i]) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[p1]);
                    tmp.add(nums[p2]);
                    ans.add(tmp);
                    p1++;
                    while (p1 < p2 && nums[p1] == nums[p1 - 1]) p1++;
                } else if (nums[p1] + nums[p2] > -nums[i]) {
                    p2--;
                } else if (nums[p1] + nums[p2] < -nums[i]) {
                    p1++;
                }
            }
        }
        return ans;
    }
}
