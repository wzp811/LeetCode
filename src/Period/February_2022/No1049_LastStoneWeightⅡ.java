package Period.February_2022;

public class No1049_LastStoneWeightⅡ {
    public int lastStoneWeightII(int[] stones){
        int sum = 0;
        for(int i=0;i<stones.length;i++) sum += stones[i];
        int[] dp = new int[sum/2+1];
        for(int i=0;i<stones.length;i++){
            for(int j=sum/2;j>=stones[i];j--) dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
        }
        return Math.abs(sum-dp[sum/2]-dp[sum/2]);
    }

    public static void main(String[] args) {
        No1049_LastStoneWeightⅡ obj = new No1049_LastStoneWeightⅡ();
//        int[] stones = new int[]{2,7,4,1,8,1};
//        int[] stones = new int[]{31,26,33,21,40};
        int[] stones = new int[]{1,2};
        System.out.println(obj.lastStoneWeightII(stones));
    }
}
