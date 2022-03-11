package Hot100;

import java.util.Arrays;
import java.util.List;

public class No312_MaxCoins {
    // 戳气球逆向思维成加气球 然后记忆化搜索
    int[][] mem;
    public int maxCoins1(int[] nums){
        int[] val = new int[nums.length+2];
        mem = new int[nums.length+2][nums.length+2];
        for(int i=0;i<nums.length+2;i++) Arrays.fill(mem[i],-1);
        for(int i=1;i<=nums.length;i++) val[i] = nums[i-1];
        val[0] = 1;
        val[nums.length+1] = 1;
        return process(val,0,nums.length+1);
    }
    // 这个函数表示对于l，r开区间上加气球，获得的最大硬币数
    public int process(int[] val,int l,int r){
        if(l>=r) return 0;
        if(mem[l][r]!=-1) return mem[l][r];
        int max = 0;
        for(int i=l+1;i<r;i++){
            max = Math.max(val[l]*val[i]*val[r]+process(val,l,i)+process(val,i,r),max);
        }
        mem[l][r] = max;
        return max;
    }

    public int maxCoins(int[] nums){
        int[] val = new int[nums.length+2];
        for(int i=1;i<=nums.length;i++) val[i] = nums[i-1];
        val[0] = 1;
        val[nums.length+1] = 1;
        int[][] dp = new int[nums.length+2][nums.length+2];
//        for(int i=0;i<nums.length;i++){
        for(int i=nums.length-1;i>=0;i--){
            for(int j=i+2;j<nums.length+2;j++){
                for(int k=i+1;k<j;k++){
                    int sum = val[i]*val[k]*val[j];
                    sum = sum+dp[i][k]+dp[k][j];
                    dp[i][j] = Math.max(sum,dp[i][j]);
                }
            }
        }
        return dp[0][nums.length+1];
    }

    public static void main(String[] args) {
        No312_MaxCoins obj = new No312_MaxCoins();
//        int[] nums = new int[]{3,1,5,8};
//        int[] nums = new int[]{1,5};
        int[] nums = new int[]{8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5};
        System.out.println(obj.maxCoins(nums));
    }
}
