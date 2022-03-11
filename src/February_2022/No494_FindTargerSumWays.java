package February_2022;

import java.util.Arrays;
import java.util.Comparator;

public class No494_FindTargerSumWays {
    public int findTargetSumWays1(int[] nums,int target){
        int sum = 0;
        for(int i=0;i<nums.length;i++) sum += nums[i];
        int cap = sum+target;
        if(cap%2==1||cap<0) return 0;
        cap /= 2;
        int[][] dp = new int[nums.length][cap+1];
        dp[0][0] = 1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<=cap;j++){
                if(i==0){
                    dp[i][j] += nums[i]==0&&j==0||j==nums[i]?1:0;
                }else if(j>=nums[i]){
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][cap];
    }
    public int findTargetSumWays(int[] nums,int target){
        int sum = 0;
        for(int i=0;i<nums.length;i++) sum += nums[i];
        int cap = sum+target;
        if(cap%2==1||cap<0) return 0;
        cap /= 2;
        int[]dp = new int[cap+1];
        dp[0] = 1;
        for(int i=0;i<nums.length;i++){
            for(int j=cap;j>=nums[i];j--){
                dp[j] = dp[j]+dp[j-nums[i]];
            }
        }
        return dp[cap];
    }
    public static void main(String[] args) {
        No494_FindTargerSumWays obj = new No494_FindTargerSumWays();
        int[] nums = new int[]{1,1,1,1,1};
//        int[] nums = new int[]{0,0,0,0,0,0,0,0,1};
        System.out.println(obj.findTargetSumWays(nums,3));
    }
}
