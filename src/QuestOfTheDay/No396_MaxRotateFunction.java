package QuestOfTheDay;

public class No396_MaxRotateFunction {
    public int maxRotateFunction(int[] nums) {
        int res = 0;
        int cur = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i] * i;
            sum += nums[i];
        }
        cur = res;
        for (int i = 0; i < nums.length; i++) {
            cur += sum;
            cur -= nums.length * nums[i];
            if (res < cur) res = cur;
            System.out.println(cur);
        }
        return res;
    }
}
