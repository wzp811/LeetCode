package QuestOfTheDay;

public class No961_RepeatedNTimes {
    public int repeatedNTimes(int[] nums) {
        if (nums[1] == nums[3]) return nums[1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }
        return nums[0];
    }
}
