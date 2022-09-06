package QuestionList.Coding_Interviews;

public class No4_SingleNumber {
    public int singleNumber1(int[] nums) {
        int res = 0;
        int digit = 1;
        for (int i = 0; i < 32; i++) {
            int cur = 0;
            for (int j = 0; j < nums.length; j++) {
                cur += (nums[j]&digit) == 0 ? 0 : 1;
            }
            res += cur % 3 == 0 ? 0 : digit;
            digit <<= 1;
        }
        return res;
    }

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num: nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
