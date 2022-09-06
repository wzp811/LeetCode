package QuestionList.Coding_Interviews_2th;

import java.util.Arrays;

public class No56_1_SingleNumbers {
    public int[] singleNumbers(int[] nums){
        int digit = 0;
        for(int i=0;i<nums.length;i++) digit ^= nums[i];
        System.out.println(digit);
        int help = 1;
        while((help&digit)==0) help <<= 1;
        System.out.println(help);
        int res1 = 0, res2 = 0;
        for(int i=0;i<nums.length;i++){
            if((nums[i]&help)==0) res1 ^= nums[i];
            else res2 ^= nums[i];
        }
        return new int[]{res1,res2};
    }

    public static void main(String[] args) {
        No56_1_SingleNumbers obj = new No56_1_SingleNumbers();
        int[] nums = new int[]{1,2,5,2};
        System.out.println(Arrays.toString(obj.singleNumbers(nums)));
    }
}
