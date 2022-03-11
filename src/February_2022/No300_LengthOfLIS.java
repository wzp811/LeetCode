package February_2022;

import java.util.Arrays;

public class No300_LengthOfLIS {
    public int lengthOfLIS(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++) if(nums[i]>nums[j]) {
                dp[i] = Math.max(dp[j] + 1, dp[i]);
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        No300_LengthOfLIS obj = new No300_LengthOfLIS();
//        int[] nums = new int[]{10,9,2,5,3,7,101,18};
//        int[] nums = new int[]{0,1,0,3,2,3};
        int[] nums = new int[]{7,7,7,7,7,7,7};
//        int[] nums = new int[]{0,3,1,6,2,2,7};
        System.out.println(obj.lengthOfLIS(nums));
    }
}
