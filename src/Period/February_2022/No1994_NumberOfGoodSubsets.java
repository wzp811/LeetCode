package Period.February_2022;

import java.util.HashSet;

public class No1994_NumberOfGoodSubsets {
    int[] prime = new int[]{2,3,5,7,11,13,17,19,23,29};
    int[] canUse = new int[]{2,3,5,6,7,10,11,13,14,15,17,19,21,22,23,26,29,30};
    int mod = 1000000007;
    public int numberOfGoodSubsets(int[] nums){
        long[] cnt = new long[31];
        int max = nums[0];
        for(int i=0;i<nums.length;i++) {
            cnt[nums[i]]++;
            max = Math.max(max,nums[i]);
        }
        long[] dp = new long[1<<10];
        dp[0] = 1;
        for(int i=0;i<cnt[1];i++) dp[0] = dp[0]*2%mod;
        System.out.println(dp[0]);
        for(int i=0;i<canUse.length&&canUse[i]<=max;i++){
            if(cnt[canUse[i]]==0) continue;
            int code = getCode(canUse[i]);
            System.out.println(canUse[i]+" "+code);
            for(int j=0;j<1024;j++){
                if((j&code)==code){
                    dp[j] = (dp[j]+dp[j^code]*cnt[canUse[i]])%mod;
                }
            }
        }
        long res = 0;
        for(int i=1;i<1024;i++){
            res += dp[i];
            res %= mod;
        }
        return (int)res;
    }

    public int getCode(int num){
        int res = 0;
        for(int i=0;i<prime.length;i++){
            res *= 2;
            res += num%prime[i]==0?1:0;
        }
        return res;
    }

    public boolean UniqueDivide(int num){
        HashSet<Integer> set = new HashSet<>();
        while(num>1){
            for(int i=0;i<prime.length&&prime[i]<=num;i++){
                if(num%prime[i]==0){
                    if(set.contains(prime[i])) return false;
                    set.add(prime[i]);
                    num /= prime[i];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No1994_NumberOfGoodSubsets obj = new No1994_NumberOfGoodSubsets();
        int[] nums = new int[]{4,2,3,15};
        System.out.println(obj.numberOfGoodSubsets(nums));
    }
}
