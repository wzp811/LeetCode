package QuestionList.QuestOfTheDay;

public class No713_NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt = 0;
        int left = 0, right = 0;
        int cur = 1;
        while (cur < k && right < nums.length) {
            cur *= nums[right++];
        }
        cnt = (right - left) * (right - left - 1) / 2;
        while (right < nums.length) {
            cur *= nums[right++];
            while (cur >= k && left < right) {
                cur /= nums[left++];
            }
            cnt += right - left;
        }
        return cnt;
    }
}
