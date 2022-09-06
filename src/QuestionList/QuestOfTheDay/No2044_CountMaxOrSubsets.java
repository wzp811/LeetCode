package QuestionList.QuestOfTheDay;

public class No2044_CountMaxOrSubsets {
    int ans = 0;
    int max = 0;

    public int countMaxOrSubsets(int[] nums) {
        for (int i = 0; i < nums.length; i++) max |= nums[i];
        process(nums, 0, 0);
        return ans;
    }

    public void process(int[] nums, int index, int cur) {
        if (index == nums.length) {
            ans += cur == max ? 1 : 0;
            return;
        }
        process(nums, index + 1, cur);
        process(nums, index + 1, cur | nums[index]);
    }
}
