package Hot100;

public class No338_CountBits {
    public int[] countBits1(int n){
        int[] ans = new int[n+1];
        for(int i=0;i<=n;i++){
            int cnt = 0;
            int cur = i;
            while(cur>0){
                cnt += cur%2;
                cur /= 2;
            }
            ans[i] = cnt;
        }
        return ans;
    }
    // 找规律
    public int[] countBits2(int n){
        int[] ans = new int[n+1];
        int dis = 2;
        ans[1] = 1;
        for(int i=2;i<=n;i++){
            if(i==2*dis) dis *= 2;
            if(i%dis<dis/2) ans[i] = ans[i-dis/2];
            else if(i%dis>=dis/2) ans[i] = ans[i-dis/2]+1;
        }
        return ans;
    }

    // 题解 动态规划 最低设置位
    // x&(x-1) 是获取将x最后一个1变成0的操作 dp将这个数加1就是当前数的1的数目
    public int[] countBits(int n){
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i] = dp[i&(i-1)]+1;
        }
        return dp;
    }
}
