package QuestionList.Coding_Interviews;

public class No12_PivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur * 2 + nums[i]  == sum) return i;
            cur += nums[i];
        }
        return -1;
    }
}
