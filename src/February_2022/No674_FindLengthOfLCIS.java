package February_2022;

import java.util.Arrays;

public class No674_FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i] = dp[i-1]+1;
                max = Math.max(dp[i],max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        No674_FindLengthOfLCIS obj = new No674_FindLengthOfLCIS();
//        int[] nums = new int[]{1,3,5,4,7};
        int[] nums = new int[]{2,2,2,2,2};
        System.out.println(obj.findLengthOfLCIS(nums));
    }
}
