package QuestionList.QuestOfTheDay;

import java.util.Arrays;

public class No462_MinMoves2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        if (nums.length % 2 == 0) {
            int res1 = 0, res2 = 0;
            int mid1 = nums[nums.length / 2];
            int mid2 = nums[nums.length / 2 - 1];
            for (int num : nums) {
                res1 += Math.abs(num - mid1);
                res2 += Math.abs(num - mid2);
            }
            return Math.min(res1, res2);
        } else {
            int res = 0;
            int mid = nums[nums.length / 2];
            for (int num : nums) res += Math.abs(num - mid);
            return res;
        }

    }
}
